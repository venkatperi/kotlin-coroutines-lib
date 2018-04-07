package com.vperi.kotlinx.coroutines.experimental.coroutine

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel

/**
 * External interface to a transform channel as seen by users of the channel.
 *
 * A transform is made up of two
 * duplex [Channel]s (one input and one output) and a non-blocking
 * transforming function that transforms incoming messages.
 *
 * From the outside ([TransformChannel], a transform channel appears as a [SendChannel]
 * on the input side and as a [ReceiveChannel] on the output side.
 *
 * From the inside ([TransformScope]) the transform channel appears as a
 * [ReceiveChannel] on the input side and a [SendChannel] for outputs.
 *
 * @param E data type on the input side
 * @param V data type on the output side
 */
interface TransformChannel<in E, out V> : SendChannel<E>, ReceiveChannel<V>

