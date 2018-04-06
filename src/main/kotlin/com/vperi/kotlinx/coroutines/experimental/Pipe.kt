package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ReceiveChannel<T>.pipe(
  destination: SendChannel<T>,
  context: CoroutineContext = DefaultDispatcher
) {
  buildPipe(context, this, destination)
}

fun <E, V> ReceiveChannel<E>.pipe(
  destination: TransformChannel<E, V>,
  context: CoroutineContext = DefaultDispatcher
): ReceiveChannel<V> =
  destination.apply {
    buildPipe(context, this@pipe, this)
  }

fun <E> buildPipe(
  context: CoroutineContext = DefaultDispatcher,
  source: ReceiveChannel<E>,
  destination: SendChannel<E>,
  start: CoroutineStart = CoroutineStart.DEFAULT,
  parent: Job? = null
): PipeCoroutine<E> =
  PipeCoroutine(
    newCoroutineContext(context, parent),
    source = source,
    destination = destination,
    active = true).apply {
    this.start(start, this, {
      source.consumeEach { destination.send(it) }
      destination.close()
    })
  }

interface PipeScope<E> : CoroutineScope {
  val source: ReceiveChannel<E>
  val destination: SendChannel<E>
}

class PipeCoroutine<E>(
  parentContext: CoroutineContext,
  override val source: ReceiveChannel<E>,
  override val destination: SendChannel<E>,
  active: Boolean
) : AbstractCoroutine<Unit>(parentContext, active),
  SendChannel<E> by destination,
  ReceiveChannel<E> by source,
  PipeScope<E> {

  override fun onCancellation(cause: Throwable?) {
    if (!source.cancel(cause) && cause != null)
      handleCoroutineException(context, cause)
  }

  override fun cancel(cause: Throwable?): Boolean =
    source.cancel(cause)
}