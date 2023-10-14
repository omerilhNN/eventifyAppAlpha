package com.omrilhn.eventifyappalpha.core.domain.models

data class EventResponse(
    val msg: String,
    val no_of_events: Int,
    val res: List<EventsItem>,
    val status: String
)
