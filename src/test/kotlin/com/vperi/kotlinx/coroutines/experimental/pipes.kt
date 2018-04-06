package com.vperi.kotlinx.coroutines.experimental

import com.google.common.io.Files
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.lang.Integer.max
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import kotlin.test.assertEquals

fun ByteBuffer.decodeUtf8(): String {
  return String(array(), StandardCharsets.UTF_8)
}

fun decodeUtf8() = transform<ByteBuffer, String> {
  input.consumeEach {
    output.send(it.decodeUtf8())
  }
}

fun splitLines() = transform<String, String> {
  val pattern = "\n"
  var prev = ""

  input.consumeEach {
    val hasNLAtEnd = it.endsWith(pattern)
    val lines = (prev + it).split(pattern)

    var toSend = listOf<String>()
    if (!hasNLAtEnd) {
      toSend += lines.subList(0, max(lines.size - 2, 0))
      prev = lines[lines.size - 1]
    } else {
      toSend += lines
      prev = ""
    }

    toSend.forEach {
      output.send(it)
    }
  }
}

class PipesTest {
  @Suppress("MemberVisibilityCanBePrivate")
  @get:Rule
  val tmpDir = TemporaryFolder()

  var lorem: Lorem = LoremIpsum.getInstance()

  @Test
  fun pipe_test() {
    val inputFile = tmpDir.newFile()
    val data = lorem.getParagraphs(1, 2)
    Files.asCharSink(inputFile, StandardCharsets.UTF_8).write(data)

    runBlocking {
      FS.createReader(inputFile.toPath())
        .pipe(decodeUtf8())
        .pipe(contents({
          assertEquals(data, it.joinToString { "" })
        }))
    }
  }

  @Test
  fun transform1() {
    val inputFile = tmpDir.newFile()
    val data = lorem.getParagraphs(1000, 2000)
    val lines = data.split("\n")
    Files.asCharSink(inputFile, StandardCharsets.UTF_8).write(data)


    runBlocking {
      val listener = Channel<String>()
//      async(coroutineContext) {
//        listener.consumeEach {
//          println(it)
//        }
//      }

      FS.createReader(inputFile.toPath())
        .pipe(decodeUtf8())
        .pipe(splitLines())
//        .pipe(tee(listener))
        .pipe(contents({
          assertEquals(lines.size, it.size)
        }))
        .pipe(nullActor())

    }
  }

}