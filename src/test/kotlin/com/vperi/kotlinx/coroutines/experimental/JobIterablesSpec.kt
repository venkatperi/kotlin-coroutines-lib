package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.TimeoutCancellationException
import kotlinx.coroutines.experimental.channels.map
import kotlinx.coroutines.experimental.channels.toList
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withTimeout
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

object JobIterablesSpec : Spek({
  val count = 10

  describe("completed") {

    it("closes stream immediately on empty list") {
      val list = getList(0)
      runBlocking {
        list.completed()
      }
    }

    it("sends jobs in order of completion") {
      val list = getList(count)
      runBlocking {
        val res = list.completed().map { it.index }.toList()
        assertEquals((0 until count).map { count - it - 1 }, res)
      }
    }
  }

  describe("all") {

    on("empty list") {
      it("completes immediately") {
        getList(0).all().awaitBlocking()
      }
    }

    on("no failing jobs") {
      it("waits for all to finish") {
        val list = getList(count)
        list.all().awaitBlocking()
        assertEquals(count, list.filter { it.isCompleted }.count())
      }
    }

    on("failing jobs") {
      it("completes on first failure") {
        val failAt = 4
        val list = getList(count, failAt)
        val e = assertCompletedExceptionally(
          list.all(), IndexedException::class)
        assertEquals(failAt, e.index)
      }
    }

  }

  describe("race") {

    on("empty list") {
      it("never completes") {
        val list = getList(0)
        assertFailsWith(TimeoutCancellationException::class) {
          runBlocking {
            withTimeout(1000) {
              list.race().await()
            }
          }
        }
      }
    }

    it("completes when first job completes") {
      val list = getList(count)
      runBlocking {
        val result = list.race().await()
        assertEquals(9, result.index)
      }
    }

    it("completes when first job fails") {
      val failAt = 4
      val list = getList(count, failAt) {
        if (it == failAt) 100L else 200L
      }
      val e = assertCompletedExceptionally(
        list.all(), IndexedException::class)
      assertEquals(failAt, e.index)
    }

  }

})