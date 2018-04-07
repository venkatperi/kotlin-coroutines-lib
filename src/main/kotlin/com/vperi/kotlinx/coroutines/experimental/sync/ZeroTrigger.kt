package com.vperi.kotlinx.coroutines.experimental.sync

import kotlinx.coroutines.experimental.Job

class ZeroTrigger(
  initial: Long,
  triggerInitially: Boolean = true,
  parent: Job? = null
) : AbstractTrigger(initial, parent) {

  init {
    test {
      when (triggerInitially && initial == 0L) {
        true -> 0L
        else -> 1  //non zero value
      }
    }
  }

  override fun test(block: () -> Long): Long {
    val v = block()
    if (!isCompleted && v == 0L)
      complete(Unit)
    return v
  }
}

