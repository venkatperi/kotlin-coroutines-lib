package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.Job

/**
 * A synchronization aid that allows one or more coroutines to wait
 * without blocking until a set of operations being performed in other
 * coroutines complete.
 *
 * A [CountDownLatch] is initialized with a given count. The
 * [await] methods block until the current count reaches zero due to
 * invocations of the [countDown] method, after which all waiting coroutines
 * are released and any subsequent invocations of await return immediately.
 *
 * Example:
 * ```kotlin
 * val count = 9L
 * val latch = CountDownLatch(count)
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
 * @constructor Constructs a [CountDownLatch] initialized with the given count.
 * @param count the number of times [countDown] must be invoked before
 *      [await] will not block.
 */
class CountDownLatch(
  count: Long,
  parent: Job? = null) :
  AbstractLatch(count, ZeroTrigger(count, true, parent)) {

  constructor(count: Int) : this(count.toLong())

  init {
    require(count >= 0) { "Count $count cannot be negative" }
  }

  fun countDown() {
    trigger.decrement()
  }
}

suspend fun withCountDown(count: Long,
  parent: Job? = null,
  block: suspend CountDownLatch.() -> Unit) {
  val latch = CountDownLatch(count, parent)
  block(latch)
  latch.await()
}

suspend fun withCountDown(count: Int,
  parent: Job? = null,
  block: suspend CountDownLatch.() -> Unit) =
  withCountDown(count.toLong(), parent, block)



