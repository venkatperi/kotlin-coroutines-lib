package com.vperi.kotlinx.coroutines.experimental

import kotlinx.coroutines.experimental.Deferred

public interface DeferredSequence<T> : Sequence<T>, Deferred<Unit>

class CompletableDeferredSequence<T>(s: Sequence<T>, d: Deferred<Unit>) : DeferredSequence<T>,
  Sequence<T> by s, Deferred<Unit> by d
