package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.future.await
import java.util.concurrent.atomic.AtomicLong

/**
 * A synchronization aid that allows one or more coroutines to wait
 * without blocking until a set of operations being performed in other
 * coroutines complete.
 *
 * A [CoCountdownLatch] is initialized with a given count. The
 * [await] methods block until the current count reaches zero due to
 * invocations of the [countDown] method, after which all waiting coroutines
 * are released and any subsequent invocations of await return immediately.
 *
 * @constructor Constructs a [CoCountdownLatch] initialized with the given count.
 * @param count the number of times [countDown] must be invoked before
 *      [await] will not block.
 */
class CoCountdownLatch(val count: Long) {
  private val latch = CompletableDeferred<Unit>()
  private val done = AtomicLong(0)

  init {
    require(count >= 0) { "Count $count cannot be negative" }
    if (count == 0L)
      latch.complete(Unit)
  }

  /**
   * Decrements the latch's count by one. If the count becomes zero,
   * suspended coroutines waiting via [await] resume immediately.
   */
  fun countDown() {
    if (!latch.isCompleted && done.incrementAndGet() == count) {
      latch.complete(Unit)
    }
  }

  /**
   * Waits until the latch has counted down to zero without blocking.
   * This suspending function is cancellable.
   *
   */
  suspend fun await() =
    latch.await()

  /**
   * If not already complete, [cancel]
   * Cancels this latch with an optional cancellation [cause].
   * The result is `true` if this job was cancelled as a result of
   * this invocation and `false` otherwise
   */
  fun cancel(cause: Throwable? = null): Boolean =
    latch.cancel(cause)

}


