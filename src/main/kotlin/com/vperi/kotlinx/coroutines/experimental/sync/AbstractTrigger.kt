package com.vperi.kotlinx.coroutines.experimental.sync

import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Job
import java.util.concurrent.atomic.AtomicLong

abstract class AbstractTrigger(
  initial: Long,
  parent: Job? = null
) : CompletableDeferred<Unit> by CompletableDeferred(parent) {
  private val value = AtomicLong(initial)

  fun increment(): Long = test({ value.incrementAndGet() })

  fun decrement(): Long = test({ value.decrementAndGet() })

  fun set(v: Long): Long = test({ value.getAndSet(v) })

  fun get(): Long = value.get()

  abstract fun test(block: () -> Long): Long
}