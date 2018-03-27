package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.filter
import kotlinx.coroutines.experimental.channels.first
import kotlinx.coroutines.experimental.channels.produce

suspend fun <T : Job> T.awaitCompletion() {
  when (this) {
    is Deferred<*> -> this.await()
    else -> this.join()
  }
}

val <T : Job> T.failed: Boolean
  get() {
    if (!isCompleted) throw IllegalStateException("Not completed")
    return when (this) {
      is Deferred<*> -> isCompletedExceptionally
      else -> isCancelled
    }
  }

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
 * or completes exceptionally with the
 *
 * If the iterable is empty, the returned [Deferred] never
 * completes.
 */
suspend fun <T : Job> Iterable<T>.race(): Deferred<Int> =
  CompletableDeferred<Int>().apply {
    completed().first { (i, it) ->
      when {
        !it.failed -> complete(i)
        else -> completeExceptionally(
          ErrorAtIndexException(i, it.failureException!!))
      }
    }
  }

suspend fun <T : Job> Iterable<T>.all(): Deferred<Unit> =
  CompletableDeferred<Unit>().apply {
    completed()
      .filter { it.value.failed }
      .first { (i, it) ->
        completeExceptionally(
          ErrorAtIndexException(i, it.failureException!!))
      }
    complete(Unit)
  }

