package com.vperi.kotlinx.coroutines.experimental

class IndexedException(
  val index: Int,
  inner: Throwable
) : Exception(inner)