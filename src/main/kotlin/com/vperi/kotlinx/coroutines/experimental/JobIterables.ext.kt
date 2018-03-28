package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*

fun <T : Job> Iterable<T>.forEachAsync(block: suspend (T) -> Unit) {
  forEach {
    async { block(it) }
  }
}

@JvmName("indexedAsync")
fun <T : Job, V : IndexedValue<T>> Iterable<V>.forEachAsync(block: suspend (V) -> Unit) {
  forEach {
    async { block(it) }
  }
}

@JvmName("mapAsync")
fun <T : Job, V : IndexedValue<T>> Iterable<V>.mapAsync(block: suspend (V) -> Unit): List<Deferred<Unit>> {
  return map {
    async { block(it) }
  }
}

fun <T : Job> Iterable<T>.forEachIndexedAsync(block: suspend (Int, T) -> Unit) {
  forEachIndexed { i, it ->
    async { block(i, it) }
  }
}

/**
 * Returns a [ReceiveChannel] which provides completed jobs from
 * the [Iterable] in the order of completion.
 *
 * Channel elements are [IndexedValue] wrappers on the [Iterable]s
 * jobs.
 */
fun <T : Job> Iterable<T>.completed(): ReceiveChannel<IndexedValue<T>> =
  produce {
    val latch = CountDownLatch(count().toLong())
    withIndex().forEachAsync {
      try {
        it.value.awaitCompletion()
      } catch (e: Exception) {
      } finally {
        latch.countDown()
        send(it)
      }
    }
    latch.await()
    close()
  }

/**
 * Completes with the index of the first [Job] that completes
 * (either successfully or exceptionally).
 *
 * If the iterable is empty, the returned [Deferred] never
 * completes.
 */
fun <T : Job> Iterable<T>.race(): Deferred<IndexedValue<T>> =
  CompletableDeferred<IndexedValue<T>>().apply {
    async {
      completed().firstOrNull()?.let {
        when {
          it.value.failed -> completeExceptionally(
            IndexedException(it.index, it.value.failureException!!))
          else -> complete(it)
        }
      }
    }
  }

/**
 * Returns a [Deferred] which completes successfully when all the
 * [Job]s in the [Iterable] complete successfully or
 * completes exceptionally with the reason of the first
 * [Job] that completes exceptionally.
 *
 * If the [Iterable] is empty, the returned [Deferred]
 * completes immediately.
 */
fun <T : Job> Iterable<T>.all(): Deferred<Unit> =
  CompletableDeferred<Unit>().apply {
    async {
      completed()
        .firstOrNull { it.value.failed }?.let { (i, it) ->
          completeExceptionally(
            IndexedException(i, it.failureException!!))
        }
      complete(Unit)
    }
  }

