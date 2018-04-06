package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlin.coroutines.experimental.CoroutineContext

interface TransformChannel<in E, out V> : SendChannel<E>, ReceiveChannel<V>

fun <E, V> transform(
  context: CoroutineContext = DefaultDispatcher,
  capacity: Int = 0,
  parent: Job? = null,
  block: suspend TransformScope<E, V>.() -> Unit
): TransformCoroutine<E, V> =
  TransformCoroutine(
    parentContext = newCoroutineContext(context, parent),
    input = Channel<E>(capacity),
    output = Channel<V>(capacity),
    active = true).apply {
    start(CoroutineStart.DEFAULT, this, block)
  }

interface TransformScope<E, V> : CoroutineScope {
  val input: Channel<E>
  val output: Channel<V>
}

class TransformCoroutine<E, V>(
  parentContext: CoroutineContext,
  override val input: Channel<E>,
  override val output: Channel<V>,
  active: Boolean
) : AbstractCoroutine<Unit>(parentContext, active),
  TransformChannel<E, V>,
  SendChannel<E> by input,
  ReceiveChannel<V> by output,
  TransformScope<E, V> {

  override fun onCancellation(cause: Throwable?) {
    if (!input.cancel(cause) && !output.cancel(cause) && cause != null)
      handleCoroutineException(context, cause)
  }

  override fun cancel(cause: Throwable?): Boolean =
    input.cancel(cause) && output.cancel(cause)
}