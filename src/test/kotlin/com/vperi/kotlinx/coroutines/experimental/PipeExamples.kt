package com.vperi.kotlinx.coroutines.experimental

import com.vperi.kotlinx.coroutines.experimental.coroutine.pipe
import com.vperi.kotlinx.coroutines.experimental.util.counter
import com.vperi.kotlinx.coroutines.experimental.util.splitter
import com.vperi.kotlinx.coroutines.experimental.util.tee
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.channels.produce
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

val paragraph = """Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
Aenean commodo ligula eget dolor. Aenean massa.
Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
Nulla consequat massa quis enim.
Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu.
In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.
Nullam dictum felis eu pede mollis pretium. Integer tincidunt.
Cras dapibus. Vivamus elementum semper nisi.
Aenean vulputate eleifend tellus.
Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.
Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus.
Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum.
Aenean imperdiet. Etiam ultricies nisi vel augue.
Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus.
Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum.
Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem.
Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus.
Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo.
Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, """

val textData = (0 until 100).joinToString("\n") { paragraph }

fun dataProducer(
  chunkSize: Int = 512
) =
  produce<String> {
    var pos = 0
    while (pos < textData.length) {
      val extent = Math.min(pos + chunkSize, textData.length)
      channel.send(textData.substring(pos, extent))
      pos = extent
    }
  }

val NL = Regex("\n")
val WS = Regex("[ \n]+")

class PipeExamples {

  @Test
  fun count_lines_and_words() {
    val lines = textData.split(NL)
    val actualLines = lines.count().toLong()
    val actualWords = lines.flatMap { it.split(WS) }.count().toLong()

    runBlocking {
      val lineCounter = CompletableDeferred<Long>()
      val wordCounter = CompletableDeferred<Long>()
      val verifyLength = Channel<String>()
      val actualDataSize = async {
        var total = 0
        verifyLength.consumeEach { total += it.length }
        total
      }

      dataProducer()                  // emit chunks of 512 bites
        .pipe(tee(verifyLength))      // verify that we're getting all of the data
        .pipe(splitter(NL))           // split into lines
        .pipe(counter(lineCounter))   // count lines
        .pipe(splitter(WS, true))     // split lines into words (words are aligned)
        .pipe(counter(wordCounter))   // count words
        .drainAndJoin()               // wait

      assertEquals(textData.length, actualDataSize.await(), "validating producer data length")
      assertEquals(actualLines, lineCounter.await(), "line count doesn't match")
      assertEquals(actualWords, wordCounter.await(), "word count doesn't match")
    }
  }

}
