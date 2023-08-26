package com.omrilhn.eventifyappalpha.app

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

@Composable
fun EventifyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

//        Crossfade(targetState = EventifyAppRouter.currentScreen, label = ""){ currentState ->
//            when (currentState.value) {
//                is Screen.SignUpScreen -> {
//                    SignUpScreen()
//                }
//                is Screen.TermsAndConditionsScreen -> {
//                   TermsAndConditionsScreen()
//                }
//                is Screen.LoginScreen -> {
//                }
//            }
//        }

    }
}