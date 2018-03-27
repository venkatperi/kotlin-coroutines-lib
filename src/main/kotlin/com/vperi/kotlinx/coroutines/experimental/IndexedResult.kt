package com.vperi.kotlinx.coroutines.experimental

sealed class IndexedResult<T>(val index: Int) {
  class Value<T>(index: Int, val value: T) : IndexedResult<T>(index)
  class Error<T>(index: Int, val error: Throwable) : IndexedResult<T>(index)
}