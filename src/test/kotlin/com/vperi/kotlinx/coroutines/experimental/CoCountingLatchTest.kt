package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.*
import org.junit.Test
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicLong
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class CoCountingLatchTest {

  @Test
  fun count() {
    val latch = CoCountingLatch(10)
    assertEquals(10, latch.count)
    assertEquals(10, latch.current)
  }

  @Test
  fun await() {
    val count = 9L
    val latch = CoCountingLatch(count)
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

  @Test(expected = TimeoutCancellationException::class)
  fun await_timeout_expires() {
    val count = 100L
    val latch = CoCountingLatch(count)
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
    val latch = CoCountingLatch(count)
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
    val latch = CoCountingLatch(count)
    runBlocking {
      (0 until count).forEach {
        async {
          latch.countDown()
        }
      }
      latch.await()
    }
  }

  @Test
  fun `when count is zero`() {
    val latch = CoCountingLatch(0)
    assertFalse(latch.isCompleted)
  }

}