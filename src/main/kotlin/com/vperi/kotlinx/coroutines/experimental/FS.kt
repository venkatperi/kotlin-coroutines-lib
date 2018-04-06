package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.channels.*
import kotlinx.coroutines.experimental.nio.aRead
import kotlinx.coroutines.experimental.nio.aWrite
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.file.OpenOption
import java.nio.file.Path
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.math.min

/**
 * Filesystem Helpers
 */
class FS {
  companion object {

    /**
     * Returns a [ReceiveChannel] for the given [file] for reading
     */
    fun createReader(
      file: Path,
      vararg options: OpenOption,
      blockSize: Int = 1024,
      context: CoroutineContext = DefaultDispatcher
    ): ReceiveChannel<ByteBuffer> =
      produce(context) {
        AsynchronousFileChannel.open(file, *options).use { input ->
          val total = input.size()
          var count = 0L
          while (count < total) {
            val size = min(blockSize.toLong(), total - count).toInt()
            ByteBuffer.allocate(size).let { buf ->
              count += input.aRead(buf, count)
              channel.send(buf)
            }
          }
        }
        channel.close()
      }

    /**
     * Returns a [SendChannel] for the given [file] for writing
     */
    fun createWriter(
      file: Path,
      vararg options: OpenOption,
      context: CoroutineContext = DefaultDispatcher
    ): SendChannel<ByteBuffer> =
      actor(context) {
        AsynchronousFileChannel.open(file, *options).use { output ->
          var position = 0L
          channel.consumeEach {
            position += output.aWrite(it, position)
          }
        }
      }
  }
}