package com.vperi.kotlin.collections

import com.google.common.collect.ImmutableList

fun <T> Iterable<T>.asImmutable(): ImmutableList<T> = ImmutableList.copyOf(this)
