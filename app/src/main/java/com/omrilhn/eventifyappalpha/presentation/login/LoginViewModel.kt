package com.omrilhn.eventifyappalpha.presentation.login

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.omrilhn.eventifyappalpha.MainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _emailText = MutableStateFlow<String>("")
    val emailText :StateFlow<String> get() = _emailText

    private val _phoneText = MutableStateFlow<String>("")
    val phoneText :StateFlow<String> get() = _phoneText

    private val _passwordText = MutableStateFlow<String>("")
    val passwordText : StateFlow<String> get() = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _phoneError = mutableStateOf("")
    val phoneError: State<String> = _phoneError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    fun setEmailText(email:String){
        _emailText.value = email
    }
    fun setPhoneText(phone:String){
        _phoneText.value = phone
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
    fun setIsPhoneError(error:String){
        _phoneError.value = error
    }

    fun onSignInResult(result :LoginResult){
        _state.update { it.copy(
            isLoginSuccesful = result.data !=null,
            loginError = result.errorMessage
        ) }
    }
    fun resetState(){
        _state.update { LoginState() }
    }

}