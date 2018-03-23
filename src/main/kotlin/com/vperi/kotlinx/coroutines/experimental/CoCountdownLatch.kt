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
 * Example:
 * ```kotlin
 * val count = 9L
 * val latch = CoCountdownLatch(count)
 * val counter = AtomicLong(0)
 *
 * runBlocking {
 *   (0 until count).forEach {
 *     async {
 *       delay(ThreadLocalRandom.current().nextInt(100, 500))
 *       counter.incrementAndGet()
 *       latch.countDown()
 *     }
 *   }
 *   latch.await()
 *   assertEquals(count, counter.get())
 *   println(counter.get())     //=> 9
 * }
 * ```
 *
 * @constructor Constructs a [CoCountdownLatch] initialized with the given count.
 * @param count the number of times [countDown] must be invoked before
 *      [await] will not block.
 */
open class CoCountdownLatch(val count: Long) {
  protected val latch = CompletableDeferred<Unit>()
  protected val done = AtomicLong(count)

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
    if (!latch.isCompleted && done.decrementAndGet() == 0L) {
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



