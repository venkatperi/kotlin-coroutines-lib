package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.AbstractCoroutine
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.handleCoroutineException
import kotlin.coroutines.experimental.CoroutineContext

class PipeCoroutine<E>(
  parentContext: CoroutineContext,
  override val source: ReceiveChannel<E>,
  override val destination: SendChannel<E>,
  active: Boolean
) : AbstractCoroutine<Unit>(parentContext, active),
  SendChannel<E> by destination,
  ReceiveChannel<E> by source,
  PipeScope<E> {

  override fun onCancellation(cause: Throwable?) {
    if (!source.cancel(cause) && cause != null)
      handleCoroutineException(context, cause)
  }

  override fun cancel(cause: Throwable?): Boolean =
    source.cancel(cause)
}