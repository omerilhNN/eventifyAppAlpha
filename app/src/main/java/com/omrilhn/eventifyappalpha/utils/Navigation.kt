package com.omrilhn.eventifyappalpha.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.omrilhn.eventifyappalpha.model.EventCardData
import com.omrilhn.eventifyappalpha.presentation.login.LoginScreen
import com.omrilhn.eventifyappalpha.presentation.login.LoginState
import com.omrilhn.eventifyappalpha.presentation.main_feed.MainFeedScreen
import com.omrilhn.eventifyappalpha.presentation.register.RegisterScreen
import com.omrilhn.eventifyappalpha.presentation.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val eventDataList = listOf(
        EventCardData("NewYear","1","1","1"),
        EventCardData("S","2","2","2"),
        EventCardData("X","3","3","3")
    )
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController, onLoginClick = {
                    navController.navigate(Screen.MainFeedScreen.route)},
                state = LoginState(false)
            )
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route){
            MainFeedScreen(navController = navController,eventDataList)
        }
    }
}