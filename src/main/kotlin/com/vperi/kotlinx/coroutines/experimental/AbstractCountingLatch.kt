package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.future.await
import java.util.concurrent.atomic.AtomicLong

abstract class AbstractCountingLatch(public val count: Long) {
  protected val latch = CompletableDeferred<Unit>()
  protected val actual = AtomicLong(count)

  init {
    require(count >= 0) { "Count $count cannot be negative" }
  }

  val current: Long get() = actual.get()

  val isCompleted: Boolean get() = latch.isCompleted

  /**
   * Decrements the latch's count by one. If the count becomes zero,
   * suspended coroutines waiting via [await] resume immediately.
   */
  fun countDown() {
    if (!latch.isCompleted && actual.decrementAndGet() == 0L) {
      latch.complete(Unit)
    }
  }

  /**
   * Waits until the latch has counted down to zero without blocking.
   * This suspending function is cancellable.
   *
   * Returns immediately if the count is zero
   */
  suspend fun await() {
    if (!latch.isCompleted)
      latch.await()
  }

  /**
   * If not already complete, [cancel]
   * Cancels this latch with an optional cancellation [cause].
   * The result is `true` if this job was cancelled as a result of
   * this invocation and `false` otherwise
   */
  fun cancel(cause: Throwable? = null): Boolean =
    latch.cancel(cause)

}



