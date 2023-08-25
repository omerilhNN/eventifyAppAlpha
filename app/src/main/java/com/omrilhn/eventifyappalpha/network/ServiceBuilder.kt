package com.omrilhn.eventifyappalpha.network

import com.omrilhn.eventifyappalpha.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit : Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL) // change this IP for testing by your actual machine IP
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val restApiService : RestApi by lazy{
        retrofit.create(RestApi::class.java)
    }

}