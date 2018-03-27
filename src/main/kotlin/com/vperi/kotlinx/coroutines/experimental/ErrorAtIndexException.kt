package com.vperi.kotlinx.coroutines.experimental

class ErrorAtIndexException(val index: Int,
  inner: Throwable) : Exception(inner)