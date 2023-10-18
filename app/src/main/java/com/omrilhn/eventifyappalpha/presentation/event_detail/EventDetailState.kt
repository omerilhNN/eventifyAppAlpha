package com.omrilhn.eventifyappalpha.presentation.event_detail

import com.omrilhn.eventifyappalpha.core.domain.models.EventResponse

data class EventDetailState(
    val eventResponse: EventResponse?=null,
    val isLoadingEvent:Boolean = false
)