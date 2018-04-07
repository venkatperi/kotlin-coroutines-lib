@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental.coroutine

import com.vperi.kotlinx.coroutines.experimental.util.consumeEachWithStats
import com.vperi.kotlinx.coroutines.experimental.util.sendWithStats
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.newCoroutineContext
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Creates a message pipe between an upstream [Channel] and a terminating
 * downstream [SendChannel].
 *
 * Launches a coroutine that [receives][ReceiveChannel.receive] messages from
 * an upstream [Channel] and [sends][SendChannel.send] them to a downstream
 * [Channel].
 *
 * Waits until all messages are drained from the upstream [ReceiveChannel].
 *
 * @param context context of the coroutine. The default value is [DefaultDispatcher].
 * @param destination the downstream [SendChannel].
 *
 */
suspend fun <T> ReceiveChannel<T>.pipe(
  destination: SendChannel<T>,
  context: CoroutineContext = DefaultDispatcher) =
  buildPipe(context, this, destination).join()

/**
 * Creates a message pipe between an upstream [Channel] and an intermediate
 * downstream [TransformChannel].
 *
 * Launches a coroutine that [receives][ReceiveChannel.receive] messages from
 * the upstream [Channel] and [sends][SendChannel.send] them to the downstream
 * [SendChannel].
 *
 * Returns the downstream [TransformChannel] as a [ReceiveChannel] for
 * further chaining.
 *
 * @param context context of the coroutine. The default value is [DefaultDispatcher].
 * @param destination the downstream [TransformChannel].
 *
 */
fun <E, V> ReceiveChannel<E>.pipe(
  destination: TransformChannel<E, V>,
  context: CoroutineContext = DefaultDispatcher
): ReceiveChannel<V> =
  destination.apply {
    buildPipe(context, this@pipe, this@apply)
  }

internal fun <E> buildPipe(
  context: CoroutineContext = DefaultDispatcher,
  source: ReceiveChannel<E>,
  destination: SendChannel<E>,
  start: CoroutineStart = CoroutineStart.DEFAULT,
  parent: Job? = null,
  active: Boolean = true
): PipeCoroutine<E> =
  PipeCoroutine(
    parentContext = newCoroutineContext(context, parent),
    source = source,
    destination = destination,
    active = active
  ).apply {
    start(start, this, {
      source.consumeEachWithStats { destination.sendWithStats(it) }
    })
    finally(context) {
      destination.close()
    }
  }
