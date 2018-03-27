package com.vperi.kotlinx.coroutines.experimental

/**
 * Like a [CountDownLatch] but the count can be increased
 * via [countUp]
 */
class CountingLatch(count: Long) :
  AbstractLatch(count, ZeroTrigger(count, false)) {
  fun countDown() {
    trigger.decrement()
  }

  fun countUp() {
    trigger.increment()
  }
}



