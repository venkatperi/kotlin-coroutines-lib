[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [AbstractLatch](./index.md)

# AbstractLatch

`open class AbstractLatch : Deferred<`[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractLatch(count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, trigger: `[`AbstractTrigger`](../-abstract-trigger/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [count](count.md) | `val count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [current](current.md) | `val current: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [trigger](trigger.md) | `val trigger: `[`AbstractTrigger`](../-abstract-trigger/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [awaitBlocking](../kotlinx.coroutines.experimental.-deferred/await-blocking.md) | `fun <T> Deferred<`[`T`](../kotlinx.coroutines.experimental.-deferred/await-blocking.md#T)`>.awaitBlocking(): `[`T`](../kotlinx.coroutines.experimental.-deferred/await-blocking.md#T) |

### Inheritors

| Name | Summary |
|---|---|
| [CountDownLatch](../-count-down-latch/index.md) | `class CountDownLatch : `[`AbstractLatch`](./index.md)<br>A synchronization aid that allows one or more coroutines to wait without blocking until a set of operations being performed in other coroutines complete. |
| [CountingLatch](../-counting-latch/index.md) | `class CountingLatch : `[`AbstractLatch`](./index.md)<br>Like a [CountDownLatch](../-count-down-latch/index.md) but the count can be increased via [countUp](../-counting-latch/count-up.md) |
