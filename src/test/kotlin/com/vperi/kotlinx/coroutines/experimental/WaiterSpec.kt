package com.vperi.kotlinx.coroutines.experimental

import com.vperi.kotlin.test.Waiter
import kotlinx.coroutines.experimental.TimeoutCancellationException
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertFailsWith

object WaiterSpec : Spek({

  describe("Waiter") {

//    it("must call await() to initialize") {
//      val waiter = Waiter()
//      assertFailsWith(IllegalStateException::class) {
//        launch {
//          waiter.resume()
//        }
//      }
//    }

    it("times out if not resumed") {
      val waiter = Waiter()
      assertFailsWith(TimeoutCancellationException::class, {
        runBlocking {
          waiter.await(100)
        }
      })
    }

    it("can be resumed") {
      Waiter().blocking(500, 2) {
        delay(100)
        resume()
        delay(100)
        resume()
      }
    }
  }

  it("self blocking") {
    Waiter().blocking(500) {
      resume()
    }
  }
})