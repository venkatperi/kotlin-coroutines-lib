[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [CoCountdownLatch](index.md) / [countDown](./count-down.md)

# countDown

`fun countDown(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Decrements the latch's count by one. If the count becomes zero,
suspended coroutines waiting via [await](await.md) resume immediately.

