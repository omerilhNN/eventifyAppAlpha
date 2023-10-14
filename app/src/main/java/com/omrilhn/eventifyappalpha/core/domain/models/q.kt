package com.omrilhn.eventifyappalpha.core.domain.models

data class q(
    val msg: String,
    val no_of_events: Int,
    val res: List<Re>,
    val status: String
)