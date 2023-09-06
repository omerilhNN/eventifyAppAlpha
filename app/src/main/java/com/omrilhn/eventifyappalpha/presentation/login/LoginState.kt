package com.omrilhn.eventifyappalpha.presentation.login

data class LoginState(
    val isLoginSuccesful:Boolean= false,
    val loginError : String? = null
)
