package com.omrilhn.eventifyappalpha.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.ImageLoader
import com.omrilhn.eventifyappalpha.model.EventCardData
import com.omrilhn.eventifyappalpha.presentation.campaign.CampaignScreen
import com.omrilhn.eventifyappalpha.presentation.login.LoginScreen
import com.omrilhn.eventifyappalpha.presentation.login.LoginState
import com.omrilhn.eventifyappalpha.presentation.main_feed.MainFeedScreen
import com.omrilhn.eventifyappalpha.presentation.notifications.NotificationsScreen
import com.omrilhn.eventifyappalpha.presentation.profile.ProfileScreen
import com.omrilhn.eventifyappalpha.presentation.register.RegisterScreen
import com.omrilhn.eventifyappalpha.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController,
    snackbarHostState: SnackbarHostState,
    imageLoader: ImageLoader
) {  NavHost(
    navController = navController,
    startDestination = Screen.SplashScreen.route,
    modifier = Modifier.fillMaxSize()
    ){
    //TRY GETTING EVENTS BY VIEWMODEL AFTER TESTING THIS
    val eventDataList = listOf(
        EventCardData("NewYear","1","1","1"),
        EventCardData("S","2","2","2"),
        EventCardData("X","3","3","3")
    )
    composable(Screen.SplashScreen.route){
        SplashScreen(navController = navController)
    }
    composable(Screen.LoginScreen.route){
        LoginScreen(navController = navController, onLoginClick = {
            navController.navigate(Screen.MainFeedScreen.route)},
            loginState = LoginState(false)
        )
    }
    composable(Screen.RegisterScreen.route){
        RegisterScreen(navController = navController)
    }
    composable(Screen.MainFeedScreen.route){
        MainFeedScreen(navController = navController,eventDataList,state = snackbarHostState)
    }
    composable(Screen.NotificationsScreen.route){
        NotificationsScreen(navController = navController,state = snackbarHostState)
    }
    composable(Screen.ProfileScreen.route){
        ProfileScreen(navController = navController,state = snackbarHostState)
    }
    composable(Screen.CampaignScreen.route){
        CampaignScreen(navController = navController,state = snackbarHostState)
    }
}



}