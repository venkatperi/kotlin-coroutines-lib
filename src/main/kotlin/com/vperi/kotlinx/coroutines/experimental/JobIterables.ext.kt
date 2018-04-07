@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental

import com.vperi.kotlinx.coroutines.experimental.sync.withCountDown
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.filter
import kotlinx.coroutines.experimental.channels.firstOrNull
import kotlinx.coroutines.experimental.channels.produce
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Returns a [ReceiveChannel] which provides completed jobs from
 * the [Iterable] in the order of completion.
 *
 * Channel elements are [IndexedValue] wrappers on the [Iterable]s
 * jobs.
 *
 * Consumes all jobs in the given [Iterable]
 */
fun <T : Job> Iterable<T>.completed(
  context: CoroutineContext = DefaultDispatcher
): ReceiveChannel<IndexedValue<T>> =
  produce(context) {
    withCountDown(count()) {
      withIndex().forEach {
        async(coroutineContext) {
          it.value.resultAsync() //block until result, but ignore it
          countDown()
          send(it)
        }
      }
    }
  }

/**
 * Like [completed], returns a [ReceiveChannel] that provides
 * only those jobs that have completed exceptionally or cancelled
 */
fun <T : Job> Iterable<T>.failed(
  context: CoroutineContext = DefaultDispatcher) =
  completed(context).filter { it.value.failed }

/**
 * Like [completed], returns a [ReceiveChannel] that provides
 * only those jobs that have completed successfully.
 */
fun <T : Job> Iterable<T>.succeeded(
  context: CoroutineContext = DefaultDispatcher
): ReceiveChannel<IndexedValue<T>> =
  completed(context).filter { !it.value.failed }

/**
 * Returns a [Deferred] that completes with the index of the
 * first [Job] that completes (either successfully or exceptionally).
 *
 * If the iterable is empty, the returned [Deferred] never
 * completes.
 */
fun <T : Job> Iterable<T>.race(
  context: CoroutineContext = DefaultDispatcher
): Deferred<IndexedValue<T>> =
  CompletableDeferred<IndexedValue<T>>().apply {
    async(context) {
      completed(context).firstOrNull()?.let {
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
fun <T : Job> Iterable<T>.all(
  context: CoroutineContext = DefaultDispatcher
): Deferred<Unit> =
  CompletableDeferred<Unit>().apply {
    async(context) {
      failed(context).firstOrNull()?.let { (i, it) ->
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
fun <T : Job> Iterable<T>.sequentially(
  context: CoroutineContext = DefaultDispatcher
): ReceiveChannel<T> =
  produce(context) {
    forEach {
      it.resultAsync()
      send(it)
    }
    close()
  }

