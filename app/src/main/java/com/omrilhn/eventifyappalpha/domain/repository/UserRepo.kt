package com.omrilhn.eventifyappalpha.domain.repository

import com.omrilhn.eventifyappalpha.network.ServiceBuilder

class UserRepo{

    private val restApiService = ServiceBuilder.userApiService



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