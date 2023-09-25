package com.omrilhn.eventifyappalpha.presentation.verification

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepository @Inject constructor(){
    suspend fun signInWithPhoneNumber(credential: AuthCredential): Unit = withContext(IO) {
        Firebase.auth.signInWithCredential(credential).await()
    }
    companion object {
        @Volatile
        var INSTANCE: AuthRepository? = null
        fun getInstance() = INSTANCE ?: synchronized(this) {
            val instance = AuthRepository()
            INSTANCE = instance
            return instance
        }
    }
}