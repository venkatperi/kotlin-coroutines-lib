@file:Suppress("unused")

package com.vperi.kotlin.test

import com.vperi.kotlinx.coroutines.experimental.sync.CountDownLatch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout
import java.util.concurrent.TimeUnit

typealias WaiterBlock = suspend Waiter.() -> Unit

fun wait(time: Long, count: Int = 1, block: WaiterBlock) {
  Waiter().blocking(time, count, block)
}

open class Waiter {
  private var latch: CountDownLatch? = null
  private val initialized = CountDownLatch(1)

  private fun initialize(count: Int) {
    check(latch == null) { "await() already called" }
    latch = CountDownLatch(count)
    initialized.countDown()
  }

  suspend fun resume() {
    initialized.await()
    latch?.countDown()
  }

  suspend fun await(time: Long, count: Int = 1) {
    initialize(count)
    actuallyAwait(time)
  }

  private suspend fun actuallyAwait(time: Long) {
    withTimeout(time, TimeUnit.MILLISECONDS) {
      latch!!.await()
    }
  }

  fun blocking(
    time: Long,
    count: Int = 1,
    block: suspend Waiter.() -> Unit
  ) {
    initialize(count)
    runBlocking {
      block()
      actuallyAwait(time)
    }
  }
}