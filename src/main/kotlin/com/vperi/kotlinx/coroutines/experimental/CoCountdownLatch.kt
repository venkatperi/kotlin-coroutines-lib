package com.vperi.kotlinx.coroutines.experimental

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
class CoCountdownLatch(count: Long) : AbstractCountingLatch(count) {
  init {
    if (count == 0L)
      latch.complete(Unit)
  }
}



