package com.omrilhn.eventifyappalpha.presentation.login

import android.app.Activity
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.events.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(


) : ViewModel() {

    private val mAuth = FirebaseAuth.getInstance()

    var verificationOtp = ""
    var popNotification = mutableStateOf<Event<String>?>(null)

    private lateinit var baseBuilder: PhoneAuthOptions.Builder

    fun setActivity(activity: Activity) {
        baseBuilder = PhoneAuthOptions.newBuilder().setActivity(activity)
    }
    fun send(mobileNum: String) {
        val options = baseBuilder
            .setPhoneNumber("+90$mobileNum")
            .setTimeout(60L, TimeUnit.SECONDS)
            .setCallbacks(object :
                PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    handledException(customMessage = "Verification Completed")

                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    handledException(customMessage = "Verification Failed")

                }

                override fun onCodeSent(otp: String, p1: PhoneAuthProvider.ForceResendingToken) {
                    super.onCodeSent(otp, p1)
                    verificationOtp = otp
                    handledException(customMessage = "Otp Send Successfully")

                }
            }).build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun otpVerification(otp: String) {
        val credential = PhoneAuthProvider.getCredential(verificationOtp, otp)
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    handledException(customMessage = "Verification Successful")

                } else {
                    handledException(customMessage =  "Wrong Otp")

                }
            }
    }


    private fun handledException(exception: Exception? = null, customMessage: String = "") {
        exception?.printStackTrace()
        val errorMsg = exception?.message ?: ""
        val message = if (customMessage.isEmpty()) {
            errorMsg
        } else {
            "$customMessage: $errorMsg"
        }
//        popNotification.value = Event(message)
    }


}