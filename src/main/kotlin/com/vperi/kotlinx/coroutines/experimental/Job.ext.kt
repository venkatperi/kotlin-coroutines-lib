package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.*

/**
 * Suspends until job is complete. Calls [Deferred.await]
 * for [Deferred].
 */
suspend fun <T : Job> T.awaitCompletion() {
  when (this) {
    is Deferred<*> -> this.await()
    else -> this.join()
  }
}

/**
 * Returns true if the job has completed exceptionally or
 * has been cancelled.
 */
val <T : Job> T.failed: Boolean
  get() {
    if (!isCompleted) throw IllegalStateException("Not completed")
    return when (this) {
      is Deferred<*> -> isCompletedExceptionally
      else -> isCancelled
    }
  }

/**
 * Returns the failure exception
 */
val <T : Job> T.failureException: Throwable?
  get() {
    if (!isCompleted) throw IllegalStateException("Not completed")
    return when (this) {
      is Deferred<*> -> when {
        this.isCompletedExceptionally -> return this.getCompletionExceptionOrNull()
        else -> null
      }
      else -> getCancellationException()
    }
  }

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
suspend fun <T : Job> Iterable<T>.race(): Deferred<IndexedValue<T>> =
  CompletableDeferred<IndexedValue<T>>().apply {
    completed().first {
      when {
        it.value.failed -> completeExceptionally(
          IndexedException(it.index, it.value.failureException!!))
        else -> complete(it)
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
suspend fun <T : Job> Iterable<T>.all(): Deferred<Unit> =
  CompletableDeferred<Unit>().apply {
    completed()
      .filter { it.value.failed }
      .firstOrNull { (i, it) ->
        completeExceptionally(
          IndexedException(i, it.failureException!!))
      }
    complete(Unit)
  }

