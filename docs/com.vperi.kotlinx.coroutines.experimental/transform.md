[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental](index.md) / [transform](./transform.md)

# transform

`fun <E, V> transform(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, capacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, parent: Job? = null, block: suspend `[`TransformScope`](-transform-scope/index.md)`<`[`E`](transform.md#E)`, `[`V`](transform.md#V)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`TransformCoroutine`](-transform-coroutine/index.md)`<`[`E`](transform.md#E)`, `[`V`](transform.md#V)`>`