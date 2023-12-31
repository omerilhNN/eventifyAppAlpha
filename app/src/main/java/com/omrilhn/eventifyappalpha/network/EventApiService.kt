package com.omrilhn.eventifyappalpha.network

import com.omrilhn.eventifyappalpha.core.domain.models.EventResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface EventApiService {
    @GET("events")
     suspend fun getEvents(): EventResponse



}