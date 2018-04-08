package com.vperi.kotlinx.coroutines.experimental.coroutine

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.handleCoroutineException
import kotlin.coroutines.experimental.CoroutineContext

class IntermediatePipeCoroutine<out E, out V>(
  parentContext: CoroutineContext,
  private val source: ReceiveChannel<E>,
  next: ReceiveChannel<V>,
  active: Boolean
) : JobWithReceiveChannel<V>(parentContext, active, next) {

  override fun onCancellation(cause: Throwable?) {
    if (!source.cancel(cause) && cause != null)
      handleCoroutineException(context, cause)
  }

  override fun cancel(cause: Throwable?): Boolean =
    source.cancel(cause)
}
