@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.runBlocking

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

suspend fun <T : Job> T.tryAwaitCompletion() {
  try {
    awaitCompletion()
  } catch (e: Exception) {
  }
}

fun <T> Deferred<T>.awaitBlocking(): T {
  return runBlocking {
    await()
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
