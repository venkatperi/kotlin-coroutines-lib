package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel

/**
 * Scope for [transform] coroutine builder
 */
interface TransformScope<out E, in V> : CoroutineScope {
  /**
   * Reference to the input channel.
   */
  val input: ReceiveChannel<E>

  /**
   * Reference to the output channel
   */
  val output: SendChannel<V>
}