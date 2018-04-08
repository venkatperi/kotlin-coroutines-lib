@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental.util

import com.vperi.kotlinx.coroutines.experimental.coroutine.TransformCoroutine
import com.vperi.kotlinx.coroutines.experimental.coroutine.then
import com.vperi.kotlinx.coroutines.experimental.coroutine.transform
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.produce
import java.lang.Integer.max
import java.nio.ByteBuffer
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.coroutines.experimental.CoroutineContext

fun <T> produce(items: Iterable<T>): ReceiveChannel<T> =
  produce {
    items.forEach { send(it) }
  }

/**
 * Returns a [SendChannel].
 *
 * Consumes all messages sent to it, ignoring them.
 */
suspend fun <T> nullActor(
  context: CoroutineContext = DefaultDispatcher,
  capacity: Int = 0) =
  actor<T>(context, capacity = capacity) {
    channel.consumeEachWithStats {}
  }

/**
 * Returns a [TransformChannel].
 *
 * Acts as a pass through where messages on the input channel are
 * sent on the output channel, as well as to the provided [listener][SendChannel].
 *
 * @param listener Receives a copy of all messages sent to this coroutine
 * @param context the coroutine context
 */
fun <T> tee(
  listener: SendChannel<T>,
  context: CoroutineContext = DefaultDispatcher) =
  transform<T, T>(context) {
    input.consumeEachWithStats {
      output.sendWithStats(it)
      listener.sendWithStats(it)
    }
    listener.close()
  }

/**
 * Returns a [TransformChannel].
 *
 * Messages sent to the input channel are transmitted on its output
 * channel. In addition, the transform also maintains a list of the
 * messages which are provided to the [callback] when the channel
 * closes.
 *
 * Best used for debugging, since the list can grow indefinitely.
 *
 * @param callback Called when the input channel closes with a copy of
 *   all messages sent to this transform.
 * @param context the coroutine context
 */
fun <T> contents(
  context: CoroutineContext = DefaultDispatcher,
  callback: suspend (List<T>) -> Unit): TransformCoroutine<T, T> {
  val elements = ConcurrentLinkedQueue<T>()
  return transform<T, T>(context) {
    input.consumeEachWithStats {
      elements.add(it)
      output.sendWithStats(it)
    }
  }.apply {
    then {
      callback(elements.toList())
    }
  }
}

/**
 * Decodes incoming [ByteBuffer]s as utf8 encoded [String].
 */
fun decodeUtf8(context: CoroutineContext = DefaultDispatcher) =
  transform<ByteBuffer, String>(context) {
    input.consumeEachWithStats {
      output.sendWithStats(it.decodeUtf8())
    }
  }

fun encodeUtf8(context: CoroutineContext = DefaultDispatcher) =
  transform<String, ByteBuffer>(context) {
    input.consumeEachWithStats {
      output.sendWithStats(it.encodeUtf8())
    }
  }

/**
 * Splits each [String] into a sequence of strings around
 * occurrences of the [delimiters] and sends each of the
 * generated strings as messages on its output.
 *
 * An incoming message may result in zero or more output messages.
 */
fun splitLines(
  context: CoroutineContext = DefaultDispatcher,
  vararg delimiters: String = listOf("\n").toTypedArray(),
  ignoreCase: Boolean = false) =
  transform<String, String>(context) {
    var prev = ""

    input.consumeEachWithStats {
      (prev + it)
        .split(*delimiters, ignoreCase = ignoreCase)
        .let { lines ->
          prev = lines.last()

          lines.take(max(0, lines.size - 1)).forEach {
            output.sendWithStats(it)
          }
        }
    }

    if (prev.isNotBlank())
      output.sendWithStats(prev)
  }
