package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel

interface PipeScope<E> : CoroutineScope {
  val source: ReceiveChannel<E>
  val destination: SendChannel<E>
}