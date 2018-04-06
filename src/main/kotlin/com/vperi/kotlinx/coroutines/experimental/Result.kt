@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental

/**
 * Represents the result of a Job/Deferred
 */
@Suppress("unused")
sealed class Result<out T> {

  val isSuccess: Boolean get() = this is Success

  val isFailure: Boolean get() = this is Failure

  fun get(): T =
    when (this) {
      is Success -> this()
      is Failure -> throw this()
    }

  fun getOrNull(): T? =
    when (this) {
      is Success -> this()
      else -> null
    }

  fun exceptionOrNull(): Throwable? =
    when (this) {
      is Failure -> this()
      else -> null
    }

  class Success<out T>(private val value: T) : Result<T>() {
    operator fun invoke(): T = value
  }

  class Failure<out T>(private val error: Throwable) : Result<T>() {
    operator fun invoke(): Throwable = error
  }
}

fun <T> resultOf(value: T): Result<T> =
  Result.Success(value)

fun resultOf(error: Throwable): Result<Unit> =
  Result.Failure(error)

fun <T> resultOf(block: () -> T): Result<T> =
  try {
    Result.Success(block())
  } catch (e: Throwable) {
    Result.Failure(e)
  }
