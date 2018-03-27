package com.vperi.kotlinx.coroutines.experimental

class IndexedException(
  val index: Int,
  val inner: Throwable
) : Exception(inner)