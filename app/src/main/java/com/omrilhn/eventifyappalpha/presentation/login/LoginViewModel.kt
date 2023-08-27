package com.omrilhn.eventifyappalpha.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _usernameText = MutableStateFlow<String>("")
    val usernameText :StateFlow<String> get() = _usernameText

    private val _passwordText = MutableStateFlow<String>("")
    val passwordText : StateFlow<String> get() = _passwordText
    private val passwordVisibleState = mutableStateOf<>()

    fun setUsernameText(username:String){
        _usernameText.value = username
    }

    fun setPasswordText(password : String)
    {
        _passwordText.value = password
    }

    

}