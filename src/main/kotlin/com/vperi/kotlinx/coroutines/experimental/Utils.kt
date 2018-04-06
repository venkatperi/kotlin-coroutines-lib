package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlin.coroutines.experimental.coroutineContext

suspend fun <T> nullActor() =
  actor<T> {
    channel.consumeEach { }
  }

suspend fun <T> spy(block: suspend (T) -> Unit) =
  transform<T, T>(coroutineContext) {
    input.consumeEach {
      output.send(it)
      block(it)
    }
  }

suspend fun <T> contents(callback: suspend (List<T>) -> Unit): TransformCoroutine<T, T> {
  val elements = ArrayList<T>()
  val t = transform<T, T>(coroutineContext) {
    input.consumeEach {
      elements.add(it)
      output.send(it)
    }
  }
  async(coroutineContext) {
    t.join()
    callback(elements)
  }
  return t
}
