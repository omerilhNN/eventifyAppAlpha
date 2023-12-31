package com.omrilhn.eventifyappalpha.network

import com.omrilhn.eventifyappalpha.model.UserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserApiManager {
    suspend fun addUser(userData: UserInfo, onResult: (UserInfo?) -> Unit){
        val retrofit = ServiceBuilder.userApiService
        retrofit.addUser(userData).enqueue(
            object : Callback<UserInfo> {
                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}