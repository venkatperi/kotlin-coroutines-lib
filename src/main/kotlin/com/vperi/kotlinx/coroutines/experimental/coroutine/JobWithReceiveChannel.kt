package com.vperi.kotlinx.coroutines.experimental.coroutine

import com.vperi.kotlinx.coroutines.experimental.util.drain
import kotlinx.coroutines.experimental.AbstractCoroutine
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlin.coroutines.experimental.CoroutineContext

abstract class JobWithReceiveChannel<out E>(
  parentContext: CoroutineContext,
  active: Boolean,
  private val receiver: ReceiveChannel<E>
) : AbstractCoroutine<Unit>(parentContext, active),
  ReceiveChannel<E> by receiver {

  override fun cancel(cause: Throwable?): Boolean {
    return receiver.cancel(cause)
  }

  suspend fun drainAndJoin() {
    receiver.drain()
    join()
  }

}

