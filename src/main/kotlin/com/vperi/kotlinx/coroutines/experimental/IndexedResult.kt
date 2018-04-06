package com.vperi.kotlinx.coroutines.experimental

public data class IndexedResult<out T>(
  public val index: Int,
  public val result: Result<T>
)