package com.omrilhn.eventifyappalpha.repository

import android.app.Service
import com.omrilhn.eventifyappalpha.network.ServiceBuilder
import com.omrilhn.eventifyappalpha.responses.UserInfoResponse
import retrofit2.Response

class UserRepository{

    private val restApiService = ServiceBuilder.restApiService



//    suspend fun getUserInfos() : Response<UserInfoResponse>{
//        return restApiService.addUser()
//    }





//    suspend fun <T> safeApiCall(
//        apiCall: suspend ()-> T): Resource<T> {

//        return withContext(Dispatchers.IO){
//            try {
//                Resource.Success(apiCall.invoke())
//            }catch (throwable: Throwable){
//                when(throwable){
//                    is HttpException ->{
//                        Resource.Failure(false,throwable.hashCode(),throwable.)
//                    }else ->{
//                        Resource.Failure(true,null,null)
//                    }
//                }
//            }
//
//        }
//    }
}