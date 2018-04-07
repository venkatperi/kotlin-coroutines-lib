package com.vperi.kotlinx.coroutines.experimental.sync

import kotlinx.coroutines.experimental.Deferred

open class AbstractLatch(
  val count: Long,
  val trigger: AbstractTrigger
) : Deferred<Unit> by trigger {

  @Suppress("unused")
  val current: Long get() = trigger.get()
}