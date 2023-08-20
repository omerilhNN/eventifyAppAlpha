package com.omrilhn.eventifyappalpha.responses

data class UserInfoResponse(
    val isSuccess: Boolean,
    val message: String,
    val returnUrl: String,
    val state: String,
    val token: String
)