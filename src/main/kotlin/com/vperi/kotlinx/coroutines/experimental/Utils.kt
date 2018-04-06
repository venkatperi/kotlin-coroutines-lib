@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental

import com.vperi.kotlin.LazyWithReceiver
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consume
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import kotlin.coroutines.experimental.CoroutineContext

val <T> ReceiveChannel<T>.stats
  by LazyWithReceiver<ReceiveChannel<T>, ChannelStats> { ChannelStats() }

val <T> SendChannel<T>.stats
  by LazyWithReceiver<SendChannel<T>, ChannelStats> { ChannelStats() }

suspend fun <E> ReceiveChannel<E>.consumeEachWithStats(action: suspend (E) -> Unit) =
  consume {
    for (element in this) {
      stats.elements.incrementAndGet()
      action(element)
    }
  }

suspend fun <E> SendChannel<E>.sendWithStats(element: E) {
  stats.elements.incrementAndGet()
  send(element)
}

suspend fun <T> nullActor(context: CoroutineContext = DefaultDispatcher) =
  actor<T>(context) {
    channel.consumeEachWithStats { }
  }

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

fun <T> contents(
  context: CoroutineContext = DefaultDispatcher,
  callback: suspend (List<T>) -> Unit
): TransformCoroutine<T, T> {
  val elements = ArrayList<T>()
  return transform<T, T>(context) {
    input.consumeEachWithStats {
      elements.add(it)
      output.sendWithStats(it)
    }
  }.apply {
    then {
      callback(elements)
    }
  }
}

fun ByteBuffer.decodeUtf8(): String {
  return String(array(), StandardCharsets.UTF_8)
}

fun decodeUtf8(context: CoroutineContext = DefaultDispatcher) =
  transform<ByteBuffer, String>(context) {
    input.consumeEachWithStats {
      output.sendWithStats(it.decodeUtf8())
    }
  }

fun splitLines(context: CoroutineContext = DefaultDispatcher) =
  transform<String, String>(context) {
    val pattern = "\n"
    var prev = ""

    input.consumeEachWithStats {
      val endsWithNL = it.endsWith(pattern)
      val lines = (prev + it).split(pattern)

      var toSend = listOf<String>()
      when {
        !endsWithNL -> {
          toSend += lines.subList(0, lines.size - 1)
          prev = lines[lines.size - 1]
        }
        else -> {
          toSend += lines
          prev = ""
        }
      }

      toSend.forEach {
        output.sendWithStats(it)
      }
    }
  }
