package com.omrilhn.eventifyappalpha.repository

abstract class BaseRepository{
    suspend fun <T> safeApiCall(
        apiCall: suspend ()->
    ):Resource{}
}