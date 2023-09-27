package com.omrilhn.eventifyappalpha.presentation.login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.omrilhn.eventifyappalpha.presentation.verification.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val mAuth = FirebaseAuth.getInstance()

    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
     var storedVerificationId : String? = null

//    private val _storedVerificationId = MutableStateFlow<String?>("")
//    val storedVerificationId : StateFlow<String?> get() = _storedVerificationId

//    private var _credential = MutableStateFlow<PhoneAuthCredential?>(PhoneAuthProvider.getCredential("",""))
//    val credential: StateFlow<PhoneAuthCredential?> get() = _credential

    private lateinit var _credential : PhoneAuthCredential

    private val _phoneNumberOtp = MutableStateFlow<String>("")
    val phoneNumberOtp : StateFlow<String> get() = _phoneNumberOtp

    private val _phoneNumberText = MutableStateFlow<String>("")
    val phoneNumberText : StateFlow<String> get() = _phoneNumberText

//    var verificationOtp = ""
//    var popNotification = mutableStateOf<Event<String>?>(null)


    private lateinit var baseBuilder: PhoneAuthOptions.Builder

    fun setActivity(activity: Activity) {
        baseBuilder = PhoneAuthOptions.newBuilder().setActivity(activity)
    }
    private var callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
//            viewModelScope.launch{
//                authRepository.signInWithPhoneNumber(credential)
//            }
            Log.d("TAG", "onVerificationCompleted:$credential")
            signInWithPhoneAuthCredential(storedVerificationId,_phoneNumberOtp.value)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w("TAG", "onVerificationFailed", e)

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
                // reCAPTCHA verification attempted with null Activity
            }

            // Show a message and update the UI
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken,
        ) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.
            Log.d("TAG", "onCodeSent:$verificationId")

            // Save verification ID and resending token so we can use them later
            storedVerificationId= verificationId
            resendToken = token
        }
    }
//    fun send(mobileNum: String) {
//        val options = baseBuilder
//            .setPhoneNumber("+90$mobileNum")
//            .setTimeout(60L, TimeUnit.SECONDS)
//            .setCallbacks(  object :
//                PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
//                    handledException(customMessage = "Verification Completed")
//                    //Update UI go to the
//
//                }
//
//                override fun onVerificationFailed(e: FirebaseException) {
//                    handledException(customMessage = "Verification Failed")
//
//                }
//
//                override fun onCodeSent(otp: String, token: PhoneAuthProvider.ForceResendingToken) {
//                    super.onCodeSent(otp, token)
//                    verificationOtp = otp
//                    handledException(customMessage = "Otp Send Successfully")
//
//                }
//            }).build()
//        PhoneAuthProvider.verifyPhoneNumber(options)
//    }
//
//    fun otpVerification(otp: String) {
//        val credential = PhoneAuthProvider.getCredential(verificationOtp, otp)
//        mAuth.signInWithCredential(credential)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    handledException(customMessage = "Verification Successful")
//                    val user = task.result?.user
//
//                } else {
//                    handledException(customMessage =  "Wrong Otp")
//
//                }
//            }
//    }
//
//
//    private fun handledException(exception: Exception? = null, customMessage: String = "") {
//        exception?.printStackTrace()
//        val errorMsg = exception?.message ?: ""
//        val message = if (customMessage.isEmpty()) {
//            errorMsg
//        } else {
//            "$customMessage: $errorMsg"
//        }
////       popNotification.value = Event()
//    }
      fun startPhoneNumberVerification(phoneNumber: String) = viewModelScope.launch{
        withContext(Dispatchers.IO){
            val options = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber("+1$phoneNumber") // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
    }

     private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
         _credential = PhoneAuthProvider.getCredential(verificationId!!, code)
    }

     fun resendVerificationCode(
        phoneNumber: String,
        token: PhoneAuthProvider.ForceResendingToken?,
    ) {
        val optionsBuilder = PhoneAuthOptions.newBuilder(mAuth)
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
        if (token != null) {
            optionsBuilder.setForceResendingToken(token) // callback's ForceResendingToken
        }
        PhoneAuthProvider.verifyPhoneNumber(optionsBuilder.build())
    }

    //Try instead verificationId,code parameters
     fun signInWithPhoneAuthCredential(verificationId: String?,code:String) {
     verifyPhoneNumberWithCode(verificationId,code)
//                viewModelScope.launch {
//            authRepository.signInWithPhoneNumber(_credential)
//        }
        mAuth.signInWithCredential(_credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithCredential:success")

                    val user = task.result?.user
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }
    fun setPhoneOtpText(otp: String){
        _phoneNumberOtp.value = otp
    }
    fun setPhoneNumberText(phone: String){
        _phoneNumberText.value = phone
    }


}