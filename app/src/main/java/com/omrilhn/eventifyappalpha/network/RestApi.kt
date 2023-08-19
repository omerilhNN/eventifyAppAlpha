package com.omrilhn.eventifyappalpha.network

import com.omrilhn.eventifyappalpha.model.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("/account/login")
    fun addUser(@Body userData: UserInfo): Call<UserInfo>
}