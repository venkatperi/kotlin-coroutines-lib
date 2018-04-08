package com.vperi.kotlinx.coroutines.experimental.coroutine

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel

/**
 * Internal interface to a transform channel as seen by the transform
 * function.
 *
 * From the inside ([TransformScope]) the transform channel appears as a
 * [ReceiveChannel] on the input side and a [SendChannel] for outputs.
 *
 * The transform function is expected to receive messages from the
 * input channel, transform them and send them on the output channel.
 *
 * @param E data type on the input side
 * @param V data type on the output side
 */
interface TransformScope<out E, in V> : CoroutineScope {
  /**
   * The input channel as a readable.
   */
  val input: ReceiveChannel<E>

  /**
   * The output channel as a writable
   */
  val output: SendChannel<V>
}

