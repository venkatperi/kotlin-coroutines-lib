package com.vperi.kotlinx.coroutines.experimental.coroutine

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Job

interface AfterScope : CoroutineScope {
  val prev: Job
}
