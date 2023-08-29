package com.omrilhn.eventifyappalpha.data

import com.omrilhn.eventifyappalpha.model.UserInfo
import com.omrilhn.eventifyappalpha.network.UserApi
import com.omrilhn.eventifyappalpha.responses.UserInfoResponse
import javax.inject.Inject

class UserRepository @Inject constructor(private val api:UserApi) {
    suspend fun addUser(userInfo: UserInfo){
        api.addUser(userInfo)
    }
    suspend fun getUser(userInfoResponse:UserInfoResponse){
        api.getUser(userInfoResponse)
    }
}