package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.future.await
import java.util.concurrent.atomic.AtomicLong

/**
 * Like a [CoCountdownLatch] but the count can be increased
 * via [countUp]
 */
class CoCountingLatch(count: Long) : CoCountdownLatch(count) {
  fun countUp() {
    if (!latch.isCompleted)
      done.incrementAndGet()
  }
}



