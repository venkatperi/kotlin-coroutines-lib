package com.vperi.kotlinx.coroutines.experimental.util

import com.vperi.kotlin.LazyWithReceiver
import com.vperi.kotlinx.coroutines.experimental.ChannelStats
import com.vperi.kotlinx.coroutines.experimental.coroutine.TransformScope2
import com.vperi.kotlinx.coroutines.experimental.coroutine.TransformScope2Impl
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.channels.*
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import kotlin.coroutines.experimental.CoroutineContext

fun ByteBuffer.decodeUtf8(): String {
  flip()
  val bytes = ByteArray(remaining())
  get(bytes)
  return String(bytes, StandardCharsets.UTF_8)
}

fun String.encodeUtf8(): ByteBuffer =
  StandardCharsets.UTF_8.encode(this)

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

/**
 * Suspends until all messages are consumed from the [ReceiveChannel]
 *
 */
suspend fun <E> ReceiveChannel<E>.drain() =
  consumeEach {}

suspend fun <E> SendChannel<E>.sendAll(items: Iterable<E>) =
  items.forEach {
    send(it)
  }

fun <E, V> ReceiveChannel<E>.transform(
  context: CoroutineContext = DefaultDispatcher,
  block: suspend TransformScope2<E, V>.() -> Unit) =
  produce<V>(context) {
    block(TransformScope2Impl(this@transform, this@produce))
  }


