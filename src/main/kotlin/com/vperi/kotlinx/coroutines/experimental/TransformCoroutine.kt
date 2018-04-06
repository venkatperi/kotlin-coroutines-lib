package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.AbstractCoroutine
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.handleCoroutineException
import kotlin.coroutines.experimental.CoroutineContext

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