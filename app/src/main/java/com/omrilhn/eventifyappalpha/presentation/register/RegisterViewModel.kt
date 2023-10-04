package com.omrilhn.eventifyappalpha.presentation.register

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.omrilhn.eventifyappalpha.domain.repository.UserRepository
import com.omrilhn.eventifyappalpha.model.UserInfo
import com.omrilhn.eventifyappalpha.responses.UserInfoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: UserRepository)
    : ViewModel() {

    private val _nameText = MutableStateFlow<String>("")
    val nameText :StateFlow<String> get() = _nameText.asStateFlow()

    private val _surnameText = MutableStateFlow<String>("")
    val surnameText :StateFlow<String> get() = _surnameText.asStateFlow()

    private val _emailText = MutableStateFlow<String>("")
    val emailText :StateFlow<String> get() = _emailText.asStateFlow()

    private val _passwordText = MutableStateFlow<String>("")
    val passwordText : StateFlow<String> get() = _passwordText.asStateFlow()

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

    suspend fun addUser(userInfo:UserInfo){
            repository.addUser(userInfo)
    }
    suspend fun getUser(userInfoResponse:UserInfoResponse) {
                Log.d("TAG","GET USER BLOCK SUCCEED")
                 repository.getUser(userInfoResponse)
         }
    }
