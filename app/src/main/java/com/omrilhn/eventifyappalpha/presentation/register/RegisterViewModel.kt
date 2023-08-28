package com.omrilhn.eventifyappalpha.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private val _nameText = MutableStateFlow<String>("")
    val nameText :StateFlow<String> get() = _nameText

    private val _surnameText = MutableStateFlow<String>("")
    val surnameText :StateFlow<String> get() = _surnameText

    private val _emailText = MutableStateFlow<String>("")
    val emailText :StateFlow<String> get() = _emailText

    private val _passwordText = MutableStateFlow<String>("")
    val passwordText : StateFlow<String> get() = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    fun setEmailText(email:String){
        _emailText.value = email
    }
    fun setNameText(name:String){
        _nameText.value = name
    }
    fun setSurnameText(surname:String){
        _surnameText.value = surname
    }

    fun setPasswordText(password : String)
    {
        _passwordText.value = password
    }
    fun setShowPassword(showPassword:Boolean){
        _showPassword.value = showPassword
    }
    fun setIsPasswordError(error:String){
        _passwordError.value = error
    }
    fun setIsEmailError(error:String){
        _emailError.value = error
    }
}