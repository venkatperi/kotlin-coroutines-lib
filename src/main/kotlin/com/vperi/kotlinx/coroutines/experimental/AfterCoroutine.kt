package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext

fun Job.then(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  success: suspend () -> Unit,
  failure: (suspend (Throwable) -> Unit)?
): AfterCoroutine<Unit> =
  AfterCoroutine<Unit>(
    newCoroutineContext(context, parent),
    true).apply {
    val startType = CoroutineStart.DEFAULT
    this@then.invokeOnCompletion { err ->
      when (err) {
        null -> this.start(startType, this, { success() })
        else -> when (failure) {
          null -> this.cancel(err)
          else -> this.start(startType, this, { failure(err) })
        }
      }
    }
  }

fun Job.finally(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  handler: suspend (Result<Unit>) -> Unit
): AfterCoroutine<Unit> =
  AfterCoroutine<Unit>(
    newCoroutineContext(context, parent),
    true).apply {
    val startType = CoroutineStart.DEFAULT
    this@finally.invokeOnCompletion { err ->
      this.start(startType, this, {
        handler(if (err == null) resultOf(Unit) else resultOf(err))
      })
    }
  }

fun Job.then(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  success: suspend () -> Unit
): AfterCoroutine<Unit> =
  then(context, parent, success, null)

fun Job.catch(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  failure: (suspend (Throwable) -> Unit)?
): AfterCoroutine<Unit> =
  then(context, parent, {}, failure)

class AfterCoroutine<in E>(
  parentContext: CoroutineContext,
  active: Boolean
) : AbstractCoroutine<E>(parentContext, active)

