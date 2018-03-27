package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.Deferred

open class AbstractLatch(
  val count: Long,
  val trigger: AbstractTrigger
) : Deferred<Unit> by trigger {

  val current: Long get() = trigger.get()

}