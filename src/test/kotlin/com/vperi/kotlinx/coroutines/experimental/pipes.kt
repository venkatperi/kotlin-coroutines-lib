package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import java.nio.ByteBuffer
import java.nio.file.Paths
import kotlin.coroutines.experimental.coroutineContext

suspend fun printer() =
  actor<String>(coroutineContext) {
    for (x in channel) {
      println(x)
    }
  }

fun stringify() = transform<ByteBuffer, String> {
  input.consumeEach {
    output.send(String(it.array()))
  }
}

fun splitLines() = transform<String, String> {
  var count = 0
  input.consumeEach {
    it.split("\n").forEach {
      output.send("${count++}: $it")
    }
  }
}

class PipesTest {

  private val loremFileName = Paths.get(System.getProperty("user.dir") + "/src/test/resources/lorem.txt")

  @Test
  fun pipe_test() {
    runBlocking {
      FS.createReadChannel(loremFileName)
        .pipe(stringify())
        .pipe(printer())
    }
  }

  @Test
  fun transform1() {

    runBlocking {
      FS.createReadChannel(loremFileName)
        .pipe(stringify())
        .pipe(splitLines())
        .pipe(printer())
    }
  }

}