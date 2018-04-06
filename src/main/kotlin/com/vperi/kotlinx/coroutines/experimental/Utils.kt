@file:Suppress("unused")

package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlin.coroutines.experimental.coroutineContext

suspend fun <T> nullActor() =
  actor<T> {
    channel.consumeEach { }
  }

suspend fun <T> tee(other: SendChannel<T>) =
  transform<T, T>(coroutineContext) {
    input.consumeEach {
      output.send(it)
      other.send(it)
    }
  }.apply {
    then {
      other.close()
    }
  }

suspend fun <T> contents(
  callback: suspend (List<T>) -> Unit): TransformCoroutine<T, T> {
  val elements = ArrayList<T>()
  return transform<T, T>(coroutineContext) {
    input.consumeEach {
      elements.add(it)
      output.send(it)
    }
  }.apply {
    then {
      callback(elements)
    }
  }
}
