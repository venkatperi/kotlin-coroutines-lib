package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.CompletableDeferred
import java.util.concurrent.atomic.AtomicLong

abstract class AbstractTrigger(
  initial: Long
) : CompletableDeferred<Unit> by CompletableDeferred() {
  private val value = AtomicLong(initial)

  fun increment(): Long = test({ value.incrementAndGet() })

  fun decrement(): Long = test({ value.decrementAndGet() })

  fun set(v: Long): Long = test({ value.getAndSet(v) })

  fun get(): Long = value.get()

  abstract fun test(block: () -> Long): Long
}

class ZeroTrigger(
  initial: Long,
  triggerInitially: Boolean = true
) : AbstractTrigger(initial) {

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

