package com.omrilhn.eventifyappalpha

import android.app.Application
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.omrilhn.eventifyappalpha.navigation.EventifyAppRouter
import com.omrilhn.eventifyappalpha.navigation.Screen
import com.omrilhn.eventifyappalpha.presentation.login.LoginScreen
import com.omrilhn.eventifyappalpha.screens.SignUpScreen
import com.omrilhn.eventifyappalpha.screens.TermsAndConditionsScreen
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class EventifyApp : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}