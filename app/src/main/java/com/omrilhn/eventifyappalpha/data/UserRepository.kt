package com.omrilhn.eventifyappalpha.data

import com.omrilhn.eventifyappalpha.model.UserInfo
import com.omrilhn.eventifyappalpha.network.UserApi
import com.omrilhn.eventifyappalpha.responses.UserInfoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val api:UserApi) {
    suspend fun addUser(userInfo: UserInfo) = withContext(Dispatchers.IO){
        api.addUser(userInfo)
    }
    suspend fun getUser(userInfoResponse:UserInfoResponse){
        api.getUser(userInfoResponse)
    }
}