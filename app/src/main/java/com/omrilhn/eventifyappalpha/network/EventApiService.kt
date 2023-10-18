package com.omrilhn.eventifyappalpha.network

import com.omrilhn.eventifyappalpha.core.domain.models.Event
import com.omrilhn.eventifyappalpha.core.domain.models.EventResponse
import com.omrilhn.eventifyappalpha.core.domain.models.EventsItem
import com.omrilhn.eventifyappalpha.utils.Constants.EVENTS_ENDPOINT
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface EventApiService {
    @GET("events")
     suspend fun getEvents(): EventResponse



}