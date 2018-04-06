package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.reflect.KClass
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

fun <V> listOfCompletableDeferred(count: Int): List<CompletableDeferred<V>> =
  (0 until count).map { CompletableDeferred<V>() }

fun getList(count: Int,
  failAt: Int? = null,
  time: ((Int) -> Long) = { (count - it) * 10L }
): List<CompletableDeferred<Int>> {
  val list = listOfCompletableDeferred<Int>(count)
  list.withIndex().forEach { (i, it) ->
    async {
      delay(time(i))
      if (i == failAt)
        it.completeExceptionally(Exception("failed at $i"))
      else
        it.complete(i)
    }
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

fun longs(count: Long,
  context: CoroutineContext = DefaultDispatcher) =
  produce<Long>(context) {
    (0 until count).forEach {
      channel.sendWithStats(it)
    }
  }

fun assertCount(channel: Any, count: Long) {
  assertEquals(count, (channel as SendChannel<*>).stats.elements.get())
  assertEquals(count, (channel as ReceiveChannel<*>).stats.elements.get())
}