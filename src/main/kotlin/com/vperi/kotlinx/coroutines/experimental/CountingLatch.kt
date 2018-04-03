package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.Job

/**
 * Like a [CountDownLatch] but the count can be increased
 * via [countUp]
 */
class CountingLatch(
  count: Long,
  parent: Job? = null
) : AbstractLatch(count, ZeroTrigger(count, false, parent)) {

  constructor(count: Int) : this(count.toLong())

  fun countDown() {
    trigger.decrement()
  }

  fun countUp() {
    trigger.increment()
  }
}



