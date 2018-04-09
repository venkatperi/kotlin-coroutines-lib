package com.vperi.kotlinx.coroutines.experimental.coroutine

import kotlinx.coroutines.experimental.AbstractCoroutine
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.handleCoroutineException
import kotlin.coroutines.experimental.CoroutineContext

class TerminatingPipeCoroutine<E>(
  parentContext: CoroutineContext,
  val source: ReceiveChannel<E>,
  @Suppress("unused") val destination: SendChannel<E>,
  active: Boolean
) : AbstractCoroutine<Unit>(parentContext, active) {

  override fun onCancellation(cause: Throwable?) {
    if (!source.cancel(cause) && cause != null)
      handleCoroutineException(context, cause)
  }

  override fun cancel(cause: Throwable?): Boolean =
    source.cancel(cause)
}

