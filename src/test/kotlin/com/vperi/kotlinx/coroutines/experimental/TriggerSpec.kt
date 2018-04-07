package com.vperi.kotlinx.coroutines.experimental

import com.vperi.kotlinx.coroutines.experimental.sync.ZeroTrigger
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object TriggerSpec : Spek({

  describe("zero trigger") {

    on("init with zero value") {
      it("completes immediately") {
        assertTrue(ZeroTrigger(0).isCompleted)
      }
    }
    on("init with non zero value") {
      it("does not complete immediately") {
        assertFalse(ZeroTrigger(10).isCompleted)
      }

      it("doesn't complete when the value is not zero") {
        val count = 5
        val trigger = ZeroTrigger(count.toLong())
        assertFalse(trigger.isCompleted)
        (0 until count - 1).forEach { trigger.decrement() }
        assertFalse(trigger.isCompleted)
      }

      it("completes when the value is zero") {
        val count = 5
        val trigger = ZeroTrigger(count.toLong())
        assertFalse(trigger.isCompleted)
        (0 until count).forEach { trigger.decrement() }
        assertTrue(trigger.isCompleted)
      }
    }

  }

})