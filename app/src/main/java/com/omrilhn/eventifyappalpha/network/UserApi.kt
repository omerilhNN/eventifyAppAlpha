package com.omrilhn.eventifyappalpha.network

import com.omrilhn.eventifyappalpha.model.UserInfo
import com.omrilhn.eventifyappalpha.responses.UserInfoResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface UserApi {
    @Headers("Content-Type: application/json")
    @POST("account/login")
    fun addUser(@Body userData: UserInfo): Call<UserInfo>

    @Headers("Content-Type: application/json")
    @GET("account/login")
     fun getUser(@Body userData: UserInfoResponse) : Response<UserInfoResponse>
}