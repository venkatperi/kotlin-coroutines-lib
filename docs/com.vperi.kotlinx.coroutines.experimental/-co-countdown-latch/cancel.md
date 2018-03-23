[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [CoCountdownLatch](index.md) / [cancel](./cancel.md)

# cancel

`fun cancel(cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

If not already complete, [cancel](./cancel.md)
Cancels this latch with an optional cancellation [cause](cancel.md#com.vperi.kotlinx.coroutines.experimental.CoCountdownLatch$cancel(kotlin.Throwable)/cause).
The result is `true` if this job was cancelled as a result of
this invocation and `false` otherwise

