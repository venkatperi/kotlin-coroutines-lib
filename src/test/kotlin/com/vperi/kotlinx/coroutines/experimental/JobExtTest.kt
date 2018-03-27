@file:Suppress("RemoveRedundantBackticks")

package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

class JobExtTest : BaseTest() {

  @Test
  fun `await all`() {
    val count = 10
    val list = (0 until count).map {
      CompletableDeferred<Int>()
    }
    list.forEachIndexed { i, it ->
      async {
        delay(i * 10)
        it.complete(i)
      }
    }
    runBlocking {
      list.all().await()
    }
  }

}

