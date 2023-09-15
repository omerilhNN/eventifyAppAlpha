package com.omrilhn.eventifyappalpha.utils

interface Paginator<T> {
    suspend fun loadNextItems()
}