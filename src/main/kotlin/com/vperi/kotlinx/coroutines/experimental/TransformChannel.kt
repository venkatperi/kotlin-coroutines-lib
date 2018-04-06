package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.newCoroutineContext
import kotlin.coroutines.experimental.CoroutineContext

interface TransformChannel<in E, out V> : SendChannel<E>, ReceiveChannel<V>

fun <E, V> transform(
  context: CoroutineContext = DefaultDispatcher,
  capacity: Int = 0,
  parent: Job? = null,
  block: suspend TransformScope<E, V>.() -> Unit
): TransformCoroutine<E, V> =
  TransformCoroutine(
    parentContext = newCoroutineContext(context, parent),
    input = Channel<E>(capacity),
    output = Channel<V>(capacity),
    active = true).apply {
    start(CoroutineStart.DEFAULT, this, block)
  }

