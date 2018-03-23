package com.vperi.kotlinx.coroutines.experimental


import kotlinx.coroutines.experimental.*
import org.junit.Test
import java.util.concurrent.ThreadLocalRandom
import kotlin.test.assertEquals

class CoCountdownLatchTest {

  @Test
  fun count() {
    val latch = CoCountdownLatch(10)
    assertEquals(10, latch.count)
  }

  @Test
  fun await() {
    val count = 9L
    val latch = CoCountdownLatch(count)
    runBlocking {
      (0 until count).forEach {
        async {
          delay(ThreadLocalRandom.current().nextInt(100, 500))
          latch.countDown()
        }
      }
      latch.await()
    }
  }

  @Test(expected = TimeoutCancellationException::class)
  fun await_timeout_expires() {
    val count = 100L
    val latch = CoCountdownLatch(count)
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
    val latch = CoCountdownLatch(count)
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
    val latch = CoCountdownLatch(count)
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