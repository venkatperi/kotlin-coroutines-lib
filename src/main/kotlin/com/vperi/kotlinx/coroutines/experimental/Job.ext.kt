@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext

suspend fun <T> Deferred<T>.resultAsync(): Result<T> =
  try {
    Result.Success(await())
  } catch (e: Throwable) {
    Result.Failure(e)
  }

suspend fun Job.resultAsync(): Result<Unit> =
  try {
    Result.Success(join())
  } catch (e: Throwable) {
    Result.Failure(e)
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

suspend fun <T> resultOfAsync(
  context: CoroutineContext = DefaultDispatcher,
  block: suspend () -> T
): Result<T> =
  async(context) { block() }.resultAsync()
