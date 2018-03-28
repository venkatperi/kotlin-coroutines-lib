package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.reflect.KClass
import kotlin.test.assertFailsWith

fun <V> listOfCompletableDeferred(count: Int): List<CompletableDeferred<V>> =
  (0 until count).map { CompletableDeferred<V>() }

fun getList(count: Int,
  failAt: Int? = null,
  time: ((Int) -> Long) = { (count - it) * 10L }
): List<CompletableDeferred<Int>> {
  val list = listOfCompletableDeferred<Int>(count)
  list.withIndex().forEachAsync { (i, it) ->
    delay(time(i))
    if (i == failAt)
      it.completeExceptionally(Exception("failed at $i"))
    else
      it.complete(i)
  }
  return list
}

fun <T, E : Exception> assertCompletedExceptionally(
  deferred: Deferred<T>,
  expected: KClass<E>): E =
  assertFailsWith(expected) {
    runBlocking {
      deferred.await()
    }
  }
