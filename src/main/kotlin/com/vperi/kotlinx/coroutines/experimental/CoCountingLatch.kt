package com.vperi.kotlinx.coroutines.experimental

/**
 * Like a [CoCountdownLatch] but the count can be increased
 * via [countUp]
 */
class CoCountingLatch(count: Long) : AbstractCountingLatch(count) {

  public fun countUp() {
    if (!latch.isCompleted)
      actual.incrementAndGet()
  }

}



