package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.channels.map
import kotlinx.coroutines.experimental.channels.toList
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertTrue

fun <V> listOfCompletableDeferred(count: Int): List<CompletableDeferred<V>> =
  (0 until count).map { CompletableDeferred<V>() }

fun getList(count: Int,
  failAt: Int? = null,
  time: ((Int) -> Long) = { (count - it) * 10L }
): List<CompletableDeferred<Int>> {
  val list = listOfCompletableDeferred<Int>(count)
  list.forEachIndexedAsync { i, it ->
    delay(time(i))
    if (i == failAt)
      it.completeExceptionally(Exception("failed at $i"))
    else
      it.complete(i)
  }
  return list
}

object JobExtSpec : Spek({
  val count = 10


  describe("Iterable<Job>.completed") {
    it("returns in order of completion") {
      val list = getList(count)
      runBlocking {
        val res = list.completed().map { it.index }.toList()
        assertEquals((0 until count).map { count - it - 1 }, res)
      }
    }
  }

  describe("Iterable<Job>.all") {

    on("has no failing jobs") {
      it("waits for all to finish") {
        val list = getList(count)
        runBlocking {
          list.all().await()
          assertEquals(count, list.filter { it.isCompleted }.count())
        }
      }
    }

    on("has failing jobs") {
      it("completes on first failure") {
        val failAt = 4
        val list = getList(count, failAt)
        runBlocking {
          val d = list.all()
          try {
            d.await()
          } catch (e: IndexedException) {
            assertEquals(failAt, e.index)
          } finally {
            assertTrue(d.isCompletedExceptionally)
          }
        }
      }
    }

  }

  describe("Iterable<Job>.race") {

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
      runBlocking {
        try {
          list.race().await()
        } catch (e: IndexedException) {
          assertEquals(failAt, e.index)
        }
      }
    }

  }

})