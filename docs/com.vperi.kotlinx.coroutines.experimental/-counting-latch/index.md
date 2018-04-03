[kotlin-coroutines-lib](../../index.md) / [com.vperi.kotlinx.coroutines.experimental](../index.md) / [CountingLatch](./index.md)

# CountingLatch

`class CountingLatch : `[`AbstractLatch`](../-abstract-latch/index.md)

Like a [CountDownLatch](../-count-down-latch/index.md) but the count can be increased
via [countUp](count-up.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CountingLatch(count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)``CountingLatch(count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parent: Job? = null)`<br>Like a [CountDownLatch](../-count-down-latch/index.md) but the count can be increased via [countUp](count-up.md) |

### Inherited Properties

| Name | Summary |
|---|---|
| [count](../-abstract-latch/count.md) | `val count: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [current](../-abstract-latch/current.md) | `val current: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [trigger](../-abstract-latch/trigger.md) | `val trigger: `[`AbstractTrigger`](../-abstract-trigger/index.md) |

### Functions

| Name | Summary |
|---|---|
| [countDown](count-down.md) | `fun countDown(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [countUp](count-up.md) | `fun countUp(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [awaitBlocking](../kotlinx.coroutines.experimental.-deferred/await-blocking.md) | `fun <T> Deferred<`[`T`](../kotlinx.coroutines.experimental.-deferred/await-blocking.md#T)`>.awaitBlocking(): `[`T`](../kotlinx.coroutines.experimental.-deferred/await-blocking.md#T) |
