package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.newCoroutineContext
import kotlin.coroutines.experimental.CoroutineContext

fun <E, V> transform(
  context: CoroutineContext = DefaultDispatcher,
  capacity: Int = 0,
  parent: Job? = null,
  start: CoroutineStart = CoroutineStart.DEFAULT,
  block: suspend TransformScope<E, V>.() -> Unit
): TransformCoroutine<E, V> =
  transformBuilder(
    context = context,
    capacity = capacity,
    start = start,
    parent = parent,
    block = block)

internal fun <E, V> transformBuilder(
  context: CoroutineContext = DefaultDispatcher,
  capacity: Int = 0,
  input: Channel<E> = Channel(capacity),
  output: Channel<V> = Channel(capacity),
  parent: Job? = null,
  start: CoroutineStart = CoroutineStart.DEFAULT,
  active: Boolean = true,
  block: suspend TransformScope<E, V>.() -> Unit
): TransformCoroutine<E, V> =
  TransformCoroutine(
    parentContext = newCoroutineContext(context, parent),
    input = input,
    output = output,
    active = active
  ).apply {
    start(start, this, block)
  }

