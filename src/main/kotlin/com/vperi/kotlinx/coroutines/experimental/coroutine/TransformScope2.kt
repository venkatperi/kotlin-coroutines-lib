package com.vperi.kotlinx.coroutines.experimental.coroutine

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel

interface TransformScope2<out E, in V> : ReceiveChannel<E>, SendChannel<V> {
  /**
   * The input channel as a readable.
   */
  val input: ReceiveChannel<E>

  /**
   * The output channel as a writable
   */
  val output: SendChannel<V>
}
