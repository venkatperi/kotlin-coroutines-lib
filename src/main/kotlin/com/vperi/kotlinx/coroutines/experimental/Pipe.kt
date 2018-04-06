package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.newCoroutineContext
import kotlin.coroutines.experimental.CoroutineContext

suspend fun <T> ReceiveChannel<T>.pipe(
  destination: SendChannel<T>,
  context: CoroutineContext = DefaultDispatcher
) =
  buildPipe(context, this, destination).join()

fun <E, V> ReceiveChannel<E>.pipe(
  destination: TransformChannel<E, V>,
  context: CoroutineContext = DefaultDispatcher
): ReceiveChannel<V> =
  destination.apply {
    buildPipe(context, this@pipe, this@apply)
  }

internal fun <E> buildPipe(
  context: CoroutineContext = DefaultDispatcher,
  source: ReceiveChannel<E>,
  destination: SendChannel<E>,
  start: CoroutineStart = CoroutineStart.DEFAULT,
  parent: Job? = null,
  active: Boolean = true
): PipeCoroutine<E> =
  PipeCoroutine(
    parentContext = newCoroutineContext(context, parent),
    source = source,
    destination = destination,
    active = active
  ).apply {
    start(start, this, {
      source.consumeEachWithStats { destination.sendWithStats(it) }
    })
    finally {
      destination.close()
    }
  }
