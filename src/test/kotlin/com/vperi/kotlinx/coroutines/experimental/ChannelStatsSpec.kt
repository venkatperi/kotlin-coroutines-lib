package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object ChannelStatsSpec : Spek({

  describe("channel stats") {
    it("works with pipe") {
      val count = 1000L
      runBlocking {
        val source = longs(count, coroutineContext)
        val sink = nullActor<Long>(coroutineContext)
        source.pipe(sink)
        assertCount(source, count)
        assertCount(sink, count)
      }
    }

    it("works with multi level pipe") {
      val count = 1000L
      runBlocking {
        val source = longs(count, coroutineContext)
        val sink = nullActor<Long>(coroutineContext)
        val contents = contents<Long>(coroutineContext) {}

        source
          .pipe(contents)
          .pipe(sink)
        assertCount(source, count)
        assertCount(contents, count)
        assertCount(sink, count)
      }
    }
  }
})