package com.vperi.kotlinx.coroutines.experimental.coroutine

import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.newCoroutineContext
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Returns a [TransformChannel].
 *
 * Launches new coroutine that receives messages from its input channel
 * and sends transformed messages on its output channel.
 *
 * The returned object is usually connected to other channels to form a directed graph.
 *
 * Upstream channels can [send][SendChannel.send] messages to,
 * and downstream channels can [receive][ReceiveChannel.receive]
 * transformed messages from this coroutine.
 *
 * @param context context of the coroutine. The default value is [DefaultDispatcher].
 * @param capacity capacity of the channel's buffer (no buffer by default).
 * @param start coroutine start option. The default value is [CoroutineStart.DEFAULT].
 * @param parent explicitly specifies the parent job, overrides job from the [context] (if any).*
 * @param block the transformation/coroutine code.
 */
fun <E, V> transform(
  context: CoroutineContext = DefaultDispatcher,
  capacity: Int = 0,
  parent: Job? = null,
  start: CoroutineStart = CoroutineStart.DEFAULT,
  block: suspend TransformScope<E, V>.() -> Unit
): TransformCoroutine<E, V> =
  transformBuilder(
    context = context,
    capacity = capacity,
    start = start,
    parent = parent,
    block = block)

internal fun <E, V> transformBuilder(
  context: CoroutineContext = DefaultDispatcher,
  capacity: Int = 0,
  input: Channel<E> = Channel(capacity),
  output: Channel<V> = Channel(capacity),
  parent: Job? = null,
  start: CoroutineStart = CoroutineStart.DEFAULT,
  active: Boolean = true,
  block: suspend TransformScope<E, V>.() -> Unit
): TransformCoroutine<E, V> =
  TransformCoroutine(
    parentContext = newCoroutineContext(context, parent),
    input = input,
    output = output,
    active = active
  ).apply {
    start(start, this, block)
    finally {
      output.close()
    }
  }

