[kotlin-coroutines-lib](../index.md) / [com.vperi.kotlinx.coroutines.experimental.util](index.md) / [splitLines](./split-lines.md)

# splitLines

`fun splitLines(context: `[`CoroutineContext`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines.experimental/-coroutine-context/index.html)` = DefaultDispatcher, vararg delimiters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = listOf("\n").toTypedArray(), ignoreCase: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`TransformCoroutine`](../com.vperi.kotlinx.coroutines.experimental.coroutine/-transform-coroutine/index.md)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`

Splits each [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) into a sequence of strings around
occurrences of the [delimiters](split-lines.md#com.vperi.kotlinx.coroutines.experimental.util$splitLines(kotlin.coroutines.experimental.CoroutineContext, kotlin.Array((kotlin.String)), kotlin.Boolean)/delimiters) and sends each of the
generated strings as messages on its output.

An incoming message may result in zero or more output messages.

