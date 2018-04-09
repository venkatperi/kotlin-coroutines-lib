package com.vperi.kotlinx.coroutines.experimental.coroutine

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel

class TransformScope2Impl<out E, in V>(
  override val input: ReceiveChannel<E>,
  override val output: SendChannel<V>
) : TransformScope2<E, V>,
  ReceiveChannel<E> by input,
  SendChannel<V> by output
