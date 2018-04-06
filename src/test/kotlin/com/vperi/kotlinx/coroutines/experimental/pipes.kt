package com.vperi.kotlinx.coroutines.experimental

import com.google.common.io.Files
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.nio.charset.StandardCharsets
import kotlin.test.assertEquals

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
      FS.createReader(inputFile.toPath(), context = coroutineContext)
        .pipe(decodeUtf8(coroutineContext))
        .pipe(contents(coroutineContext, {
          assertEquals(data, it.joinToString { "" })
        }))
        .pipe(nullActor(coroutineContext))
    }
  }

  @Test
  fun transform1() {
    val inputFile = tmpDir.newFile()
//    val data = lorem.getParagraphs(1000, 2000)
    val data = (0 until 10000).joinToString("\n") { "$it" }
    val lines = data.split("\n")
    Files.asCharSink(inputFile, StandardCharsets.UTF_8).write(data)

    runBlocking {
      val listener = Channel<String>()
      val count = async(coroutineContext) {
        var count = 0
        listener.consumeEach { count++ }
        count
      }

      val splitter = splitLines(coroutineContext)
      FS.createReader(inputFile.toPath())
        .pipe(decodeUtf8(coroutineContext))
        .pipe(splitter)
        .pipe(tee(listener))
        .pipe(contents(coroutineContext, {
          assertEquals(lines.size, it.size)
        }))
        .pipe(nullActor(coroutineContext))

//      assertEquals(lines.size, count.await())
    }
  }

}