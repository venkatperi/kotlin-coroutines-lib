package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.channels.Channel

interface TransformScope<E, V> : CoroutineScope {
  val input: Channel<E>
  val output: Channel<V>
}