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

object JobExtSpec : Spek({

  describe("list of jobs") {

    describe("completed") {
      val count = 10

      it("returns in order of completion") {
        val list = listOfCompletableDeferred<Int>(count)
        list.forEachIndexedAsync { i, it ->
          delay((count - i) * 10)
          it.complete(i)
        }
        runBlocking {
          val res = list.completed().map { it.index }.toList()
          assertEquals((0 until count).map { count - it - 1 }, res)
        }
      }
    }

    describe("await all") {
      val count = 10

      on("no failures") {
        it("waits for all to finish") {
          val list = listOfCompletableDeferred<Int>(count)
          list.forEachIndexedAsync { i, it ->
            delay(i * 10)
            it.complete(i)
          }
          runBlocking {
            list.all().await()
            assertEquals(count, list.filter { it.isCompleted }.count())
          }
        }
      }

      on("failure") {
        it("waits for all to finish") {
          val list = listOfCompletableDeferred<Int>(count)
          list.forEachIndexedAsync { i, it ->
            delay(i * 10)
            if (i == 1)
              it.completeExceptionally(Exception("failure at $i"))
            else
              it.complete(i)
          }
          runBlocking {
            val d = list.all()
            try {
              d.await()
            } catch (e: ErrorAtIndexException) {
              assertEquals(1, e.index)
            } finally {
              assertTrue(d.isCompletedExceptionally)
            }
          }
        }
      }

    }
  }

})