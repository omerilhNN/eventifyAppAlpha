package com.omrilhn.eventifyappalpha.core.domain.repository

import android.util.Log
import com.omrilhn.eventifyappalpha.core.domain.models.EventsItem
import com.omrilhn.eventifyappalpha.core.domain.models.Resource
import com.omrilhn.eventifyappalpha.data.DataOrException
import com.omrilhn.eventifyappalpha.network.EventApiService
import retrofit2.Response
import javax.inject.Inject

class EventRepository @Inject constructor(private val eventApiService: EventApiService) {
    private val listOfEvents =
        DataOrException<ArrayList<EventsItem>, Boolean, Exception>()

        suspend fun getEvents(): DataOrException<ArrayList<EventsItem>,Boolean, Exception>{
        try{
            listOfEvents.loading = true
            listOfEvents.data = eventApiService.getEvents()
            if(listOfEvents.data.toString().isNotEmpty()) listOfEvents.loading = false
        }
        catch (exception:Exception){
            listOfEvents.e = exception
            Log.d("TAG","getAllEvents: ${listOfEvents.e!!.localizedMessage}")
        }
        return listOfEvents
    }

}