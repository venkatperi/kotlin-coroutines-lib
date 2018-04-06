package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.nio.aRead
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.file.Path
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Filesystem Helpers
 */
class FS {
  companion object {

    /**
     * Returns a [ReceiveChannel] for the given [file]
     */
    fun createReadChannel(
      file: Path,
      context: CoroutineContext = DefaultDispatcher
    ): ReceiveChannel<ByteBuffer> =
      produce(context) {
        AsynchronousFileChannel.open(file).use { input ->
          var count = 0L
          while (count < input.size()) {
            ByteBuffer.allocate(1024).let { buf ->
              count += input.aRead(buf, count)
              channel.send(buf)
            }
          }
        }
      }
  }
}