package com.omrilhn.eventifyappalpha.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("rememberLogin") val rememberLogin: Boolean,
    @SerializedName("returnUrl") val returnUrl: String
)