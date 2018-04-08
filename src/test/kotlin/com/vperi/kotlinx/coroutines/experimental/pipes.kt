package com.vperi.kotlinx.coroutines.experimental

import com.google.common.io.Files
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import com.vperi.kotlinx.coroutines.experimental.coroutine.pipe
import com.vperi.kotlinx.coroutines.experimental.util.*
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.count
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

  private var lorem: Lorem = LoremIpsum.getInstance()

  @Test
  fun pipe_test() {
    val inputFile = tmpDir.newFile()
    val data = lorem.getParagraphs(1, 2)
    Files.asCharSink(inputFile, StandardCharsets.UTF_8).write(data)

    runBlocking {
      FS.createReader(inputFile.toPath())
        .pipe(decodeUtf8())
        .pipe(contents {
          assertEquals(data, it.joinToString { "" })
        })
        .drainAndJoin()
    }
  }

  @Test
  fun pipe_test2() {
    val count = 50000
    val data = (0 until count)

    runBlocking {
      val listener = Channel<Int>()
      val counter = async {
        listener.count()
      }

      produce(data)
        .pipe(tee(listener))
        .drainAndJoin()

      assertEquals(count, counter.await())
    }
  }

  @Test
  fun write_to_file() {
    val file = tmpDir.newFile()
    val count = 50000
    val data = (0 until count).map { "$it" }

    runBlocking {
      produce(data)
        .pipe(encodeUtf8())
        .pipe(FS.createWriter(file.toPath()))
        .join()
    }
  }

  @Test
  fun transform1() {
    val inputFile = tmpDir.newFile()
    val data = lorem.getParagraphs(10000, 20000)
    val lines = data.split("\n")
    Files.asCharSink(inputFile, StandardCharsets.UTF_8).write(data)

    runBlocking {
      val listener = Channel<String>()
      val count = async {
        listener.count()
      }

      val splitter = splitLines()
      val teeListener = tee(listener)
      FS.createReader(inputFile.toPath())
        .pipe(decodeUtf8())
        .pipe(splitter)
        .pipe(teeListener)
        .pipe(contents {
          assertEquals(lines.size, it.size)
        })
        .drainAndJoin()

      assertEquals(lines.size, count.await())
//      assertCount(teeListener, lines.size.toLong())
    }
  }

}
