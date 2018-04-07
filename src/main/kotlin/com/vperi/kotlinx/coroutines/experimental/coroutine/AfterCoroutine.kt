@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental.coroutine

import com.vperi.kotlinx.coroutines.experimental.Result
import com.vperi.kotlinx.coroutines.experimental.resultOf
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext

fun Job.then(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  successHandler: suspend () -> Unit,
  failureHandler: (suspend (Throwable) -> Unit)?
): Job =
  afterBuilder(context, parent)
    .apply {
      val startType = CoroutineStart.DEFAULT
      this@then.invokeOnCompletion { err ->
        when (err) {
          null -> this.start(startType, this, { successHandler() })
          else -> when (failureHandler) {
            null -> this.cancel(err)
            else -> this.start(startType, this, { failureHandler(err) })
          }
        }
      }
    }

fun Job.finally(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  handler: suspend (Result<Unit>) -> Unit
): Job =
  afterBuilder(context, parent)
    .apply {
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
): Job =
  then(context, parent, success, null)

fun Job.catch(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  failure: (suspend (Throwable) -> Unit)
): Job =
  then(context, parent, {}, failure)

internal fun afterBuilder(
  context: CoroutineContext = DefaultDispatcher,
  parent: Job? = null,
  active: Boolean = true
): AfterCoroutine =
  AfterCoroutine(
    parentContext = newCoroutineContext(context, parent),
    active = active
  )

class AfterCoroutine(
  parentContext: CoroutineContext,
  active: Boolean = true
) : AbstractCoroutine<Unit>(parentContext, active)

