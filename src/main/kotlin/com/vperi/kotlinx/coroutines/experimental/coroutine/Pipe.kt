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
fun <T> ReceiveChannel<T>.pipe(
  destination: SendChannel<T>,
  context: CoroutineContext = DefaultDispatcher): Job =
  TerminatingPipeCoroutine(
    parentContext = newCoroutineContext(context, null),
    source = this,
    destination = destination,
    active = true
  ).apply {
    this.start(CoroutineStart.DEFAULT,
      this@pipe, {
      source.consumeEachWithStats { destination.sendWithStats(it) }
    })
    finally(context) {
      destination.close()
    }
  }

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
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null
): JobWithReceiveChannel<V> =
  IntermediatePipeCoroutine(
    parentContext = newCoroutineContext(context, parent),
    source = this,
    next = destination,
    active = true
  ).apply {
    this.start(CoroutineStart.DEFAULT, this@pipe, {
      consumeEachWithStats { destination.sendWithStats(it) }
    })
    finally(context) {
      destination.close()
    }
  }

