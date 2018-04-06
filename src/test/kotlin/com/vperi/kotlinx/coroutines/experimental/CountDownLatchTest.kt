package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.*
import org.junit.Test
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicLong
import kotlin.test.assertEquals

class CountDownLatchTest {

  @Test
  fun count() {
    val latch = CountDownLatch(10)
    assertEquals(10, latch.count)
  }

  @Test
  fun await() {
    val count = 9L
    val latch = CountDownLatch(count)
    val counter = AtomicLong(0)
    runBlocking {
      (0 until count).forEach {
        async {
          delay(ThreadLocalRandom.current().nextInt(100, 500))
          counter.incrementAndGet()
          latch.countDown()
        }
      }
      latch.await()
      assertEquals(count, counter.get())
      println(counter.get())
    }
  }

  @Test
  fun builder() {
    val count = 9L
    val counter = AtomicLong(0)
    runBlocking {
      withCountDown(count) {
        (0 until count).forEach {
          async {
            delay(ThreadLocalRandom.current().nextInt(100, 500))
            counter.incrementAndGet()
            countDown()
          }
        }
      }
    }
    assertEquals(count, counter.get())
  }

  @Test(expected = TimeoutCancellationException::class)
  fun await_timeout_expires() {
    val count = 100L
    val latch = CountDownLatch(count)
    runBlocking {
      withTimeout(50) {
        (0 until count).forEach {
          async {
            delay(ThreadLocalRandom.current().nextInt(300, 500))
            latch.countDown()
          }
        }
        latch.await()
      }
    }
  }

  @Test
  fun await_timeout_does_not_expire() {
    val count = 100L
    val latch = CountDownLatch(count)
    var x = 0
    runBlocking {
      withTimeout(1000) {
        (0 until count).forEach {
          async {
            delay(ThreadLocalRandom.current().nextInt(300, 500))
            latch.countDown()
          }
        }
        latch.await()
        x = 1
      }
      assertEquals(1, x)
    }
  }

  @Test
  fun stress() {
    val count = 1000000L
    val latch = CountDownLatch(count)
    runBlocking {
      (0 until count).forEach {
        async {
          latch.countDown()
        }
      }
      latch.await()
    }
  }

}