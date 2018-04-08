@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental.coroutine

import com.vperi.kotlinx.coroutines.experimental.Result
import com.vperi.kotlinx.coroutines.experimental.resultOf
import kotlinx.coroutines.experimental.AbstractCoroutine
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.Job
import kotlin.coroutines.experimental.CoroutineContext

internal class AfterCoroutine(
  parentContext: CoroutineContext,
  override val prev: Job,
  active: Boolean = true
) : AbstractCoroutine<Unit>(parentContext, active),
  AfterScope {

  private fun doStart(block: suspend AfterCoroutine.() -> Unit) =
    this.start(CoroutineStart.DEFAULT, this, block)

  fun doAfter(
    err: Throwable?,
    successHandler: suspend AfterScope.() -> Unit,
    failureHandler: (suspend AfterScope.(Throwable) -> Unit)?) {
    when (err) {
      null -> doStart { successHandler() }
      else -> when (failureHandler) {
        null -> this.cancel(err)
        else -> doStart { failureHandler(err) }
      }
    }
  }

  fun doFinally(
    err: Throwable?,
    handler: suspend AfterScope.(Result<Unit>) -> Unit) =
    doStart { handler(resultOf(err)) }
}

