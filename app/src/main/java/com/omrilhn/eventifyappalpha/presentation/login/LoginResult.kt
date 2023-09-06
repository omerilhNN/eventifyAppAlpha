package com.omrilhn.eventifyappalpha.presentation.login

data class LoginResult(
    val data:UserData?,
    val errorMessage:String?
)

data class UserData(
    val userId:String,
    val username:String?,
    val profilePictureUrl:String?
)
