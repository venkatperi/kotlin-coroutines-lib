package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel

interface TransformChannel<in E, out V> : SendChannel<E>, ReceiveChannel<V>

