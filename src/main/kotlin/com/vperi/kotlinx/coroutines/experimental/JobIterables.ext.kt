@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.filter
import kotlinx.coroutines.experimental.channels.firstOrNull
import kotlinx.coroutines.experimental.channels.produce

/**
 * Performs the given [action] asynchronously on each element.
 */
fun <T : Job> Iterable<T>.forEachAsync(action: suspend (T) -> Unit) {
  forEach {
    async { action(it) }
  }
}

/**
 * Performs the [action] asynchronously on each element as an
 * [IndexedValue].
 */
@JvmName("indexedAsync")
fun <T : Job, V : IndexedValue<T>> Iterable<V>.forEachAsync(action: suspend (V) -> Unit) {
  forEach {
    async { action(it) }
  }
}

/**
 * Returns a [ReceiveChannel] which provides completed jobs from
 * the [Iterable] in the order of completion.
 *
 * Channel elements are [IndexedValue] wrappers on the [Iterable]s
 * jobs.
 *
 * Consumes all jobs in the given [Iterable]
 */
fun <T : Job> Iterable<T>.completed(): ReceiveChannel<IndexedValue<T>> =
  produce {
    val latch = CountDownLatch(count().toLong())
    withIndex().forEachAsync {
      it.value.tryAwaitCompletion()
      latch.countDown()
      send(it)
    }
    latch.await()
    close()
  }

/**
 * Like [completed], returns a [ReceiveChannel] that provides
 * only those jobs that have completed exceptionally or cancelled
 */
fun <T : Job> Iterable<T>.failed(): ReceiveChannel<IndexedValue<T>> =
  completed().filter { it.value.failed }

/**
 * Like [completed], returns a [ReceiveChannel] that provides
 * only those jobs that have completed successfully.
 */
fun <T : Job> Iterable<T>.succeeded(): ReceiveChannel<IndexedValue<T>> =
  completed().filter { !it.value.failed }

/**
 * Returns a [Deferred] that completes with the index of the
 * first [Job] that completes (either successfully or exceptionally).
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
      failed().firstOrNull()?.let { (i, it) ->
        completeExceptionally(
          IndexedException(i, it.failureException!!))
      }
      complete(Unit)
    }
  }

/**
 * Returns completed jobs from the given [Iterable] in
 * a sequentially manner.
 */
fun <T : Job> Iterable<T>.sequentially(): ReceiveChannel<T> =
  produce {
    forEach {
      it.tryAwaitCompletion()
      send(it)
    }
    close()
  }

