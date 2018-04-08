package com.vperi.kotlinx.coroutines.experimental.coroutine

import com.vperi.kotlinx.coroutines.experimental.Result
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.newCoroutineContext
import kotlin.coroutines.experimental.CoroutineContext

fun Job.then(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  successHandler: suspend AfterScope.() -> Unit,
  failureHandler: (suspend AfterScope.(Throwable) -> Unit)?
): Job =
  afterBuilder(context, parent, this).apply {
    this@then.invokeOnCompletion {
      doAfter(it, successHandler, failureHandler)
    }
  }

fun Job.finally(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  handler: suspend AfterScope.(Result<Unit>) -> Unit
): Job =
  afterBuilder(context, parent, this).apply {
    this@finally.invokeOnCompletion {
      doFinally(it, handler)
    }
  }

fun Job.then(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  success: suspend AfterScope.() -> Unit
): Job =
  then(context, parent, success, null)

fun Job.catch(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  failure: (suspend AfterScope.(Throwable) -> Unit)
): Job =
  then(context, parent, {}, failure)

internal fun afterBuilder(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  prev: Job,
  active: Boolean = true
): AfterCoroutine =
  AfterCoroutine(
    parentContext = newCoroutineContext(context, parent),
    active = active,
    prev = prev
  )

