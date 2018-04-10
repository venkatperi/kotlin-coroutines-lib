@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental.util

import com.vperi.kotlinx.coroutines.experimental.coroutine.TransformChannel
import com.vperi.kotlinx.coroutines.experimental.coroutine.TransformCoroutine
import com.vperi.kotlinx.coroutines.experimental.coroutine.then
import com.vperi.kotlinx.coroutines.experimental.coroutine.transform
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.channels.*
import java.nio.ByteBuffer
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicLong
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Convenience function: Returns a [producer][ReceiveChannel]
 * for the given [items] Iterable.
 *
 */
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

fun <T> counter(
  result: CompletableDeferred<Long>,
  context: CoroutineContext = DefaultDispatcher
): TransformCoroutine<T, T> {
  return transform(context) {
    val total = AtomicLong(0L)
    input.consumeEachWithStats {
      output.sendWithStats(it)
      total.incrementAndGet()
    }
    result.complete(total.get())
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
 * occurrences of the [regex] and sends each of the
 * generated strings as messages on its output.
 *
 * An incoming message may result in zero or more output messages.
 * @param aligned tells splitter that incoming messages are aligned, i.e output message won't
 *   be split over two incoming messages.
 */
fun splitter(
  regex: Regex,
  aligned: Boolean = false,
  context: CoroutineContext = DefaultDispatcher) =
  transform<String, String>(context) {
    var prev = ""

    input.consumeEachWithStats {
      (prev + it).split(regex).let {
        val (items, remainder) = when (aligned) {
          true -> it to ""
          else -> it.takeAllBut(1) to it.last()
        }
        prev = remainder

        items.forEach {
          output.sendWithStats(it)
        }
      }
    }

    if (prev.isNotBlank())
      output.sendWithStats(prev)
  }

fun ReceiveChannel<String>.split(
  regex: Regex,
  aligned: Boolean = false,
  context: CoroutineContext = DefaultDispatcher) =
  transform(context) {
    var prev = ""

    consumeEach {
      (prev + it).split(regex).let {
        val (items, remainder) = when (aligned) {
          true -> it to ""
          else -> it.takeAllBut(1) to it.last()
        }
        prev = remainder

        sendAll(items)
      }
    }

    if (prev.isNotBlank())
      send(prev)
  }

fun <T> ReceiveChannel<T>.tee(
  context: CoroutineContext = DefaultDispatcher,
  listener: SendChannel<T>
) =
  transform<T, T>(context) {
    consumeEach {
      listener.send(it)
      send(it)
    }
    listener.close()
  }

fun <T> ReceiveChannel<T>.countMessages(
  result: CompletableDeferred<Long>,
  context: CoroutineContext = DefaultDispatcher) =
  transform<T, T>(context) {
    result.complete(sumBy({
      send(it)
      1
    }))
  }

fun ReceiveChannel<ByteBuffer>.decodeUtf8(
  context: CoroutineContext = DefaultDispatcher) =
  map(context) { it.decodeUtf8() }
//  transform<ByteBuffer, String>(context) {
//    consumeEach {
//      send(it.decodeUtf8())
//    }
//  }

fun ReceiveChannel<String>.encodeUtf8(
  context: CoroutineContext = DefaultDispatcher) =
  map(context) { it.encodeUtf8() }
//  transform<String, ByteBuffer>(context) {
//    consumeEach {
//      send(it.encodeUtf8())
//    }
//  }

public suspend inline fun <E> ReceiveChannel<E>.sumBy(
  selector: (E) -> Long): Long {
  var sum = 0L
  consumeEach {
    sum += selector(it)
  }
  return sum
}
