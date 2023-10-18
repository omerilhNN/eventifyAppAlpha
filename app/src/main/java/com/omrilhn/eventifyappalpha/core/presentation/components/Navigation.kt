package com.omrilhn.eventifyappalpha.core.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.ImageLoader
import com.omrilhn.eventifyappalpha.model.EventCardData
import com.omrilhn.eventifyappalpha.network.EventApiService
import com.omrilhn.eventifyappalpha.presentation.campaign.CampaignScreen
import com.omrilhn.eventifyappalpha.presentation.event_detail.EventDetailScreen
import com.omrilhn.eventifyappalpha.presentation.verification.AuthenticationViewModel
import com.omrilhn.eventifyappalpha.presentation.login.LoginScreen
import com.omrilhn.eventifyappalpha.presentation.login.LoginState
import com.omrilhn.eventifyappalpha.presentation.login.LoginViewModel
import com.omrilhn.eventifyappalpha.presentation.main_feed.MainFeedScreen
import com.omrilhn.eventifyappalpha.presentation.main_feed.MainFeedViewModel
import com.omrilhn.eventifyappalpha.presentation.main_feed.TestScreen
import com.omrilhn.eventifyappalpha.presentation.notifications.NotificationsScreen
import com.omrilhn.eventifyappalpha.presentation.personal_detail.PersonalDetailScreen
import com.omrilhn.eventifyappalpha.presentation.personal_detail.PersonalDetailViewModel
import com.omrilhn.eventifyappalpha.presentation.profile.ProfileScreen
import com.omrilhn.eventifyappalpha.presentation.register.RegisterScreen
import com.omrilhn.eventifyappalpha.presentation.splash.SplashScreen
import com.omrilhn.eventifyappalpha.presentation.verification.VerificationScreen
import com.omrilhn.eventifyappalpha.utils.Screen

@Composable
fun Navigation(
    navController: NavHostController,
    snackbarHostState: SnackbarHostState,
//    activity:Activity
    imageLoader: ImageLoader
) {
    val authViewModel = hiltViewModel<AuthenticationViewModel>()
    val loginViewModel = hiltViewModel<LoginViewModel>()
    val personalDetailViewModel = hiltViewModel<PersonalDetailViewModel>()
    val mainFeedViewModel = hiltViewModel<MainFeedViewModel>()

    val phoneText by authViewModel.phoneNumberText.collectAsState()
    val phoneOtp by authViewModel.phoneNumberOtp.collectAsState()
    val verificationId by authViewModel.storedVerificationId.collectAsState()

    NavHost(
    navController = navController,
    startDestination = Screen.SplashScreen.route  ,
    modifier = Modifier.fillMaxSize()
    ){

    composable(Screen.SplashScreen.route){
        SplashScreen(navController = navController)
    }
    composable(Screen.LoginScreen.route){
        LoginScreen(navController = navController,
            loginViewModel = loginViewModel,
            authViewModel = authViewModel,
            onLoginClick = {
//            navController.navigate(Screen.MainFeedScreen.route)
             authViewModel.startPhoneNumberVerification(phoneText)
             navController.navigate(Screen.VerificationScreen.route)
             },
            loginState = LoginState(false)
//            activity = activity
//
        )
    }
    composable(Screen.VerificationScreen.route){
        VerificationScreen(navController = navController,
            loginViewModel = loginViewModel,
            authViewModel = authViewModel,
            loginState =LoginState(true),
            onSubmitClick = {
                Log.d("TAG","ONSUBMIT BUTTON CLICKED")
                authViewModel.signInWithPhoneAuthCredential(verificationId,phoneOtp ) ///!!!!!!! error
            })
    }
    composable(Screen.RegisterScreen.route){
        RegisterScreen(navController = navController)
    }
    composable(Screen.PersonalDetail.route) {
        PersonalDetailScreen(navController = navController,
            personalDetailViewModel = personalDetailViewModel,
            onSubmitClick = {
                Log.d("TAG", "SubmitButtonClicked ${navController.currentDestination}")
            }
        )
    }
    composable(route = Screen.EventDetailScreen.route +"{id}?shouldShowKeyboard={shouldShowKeyboard}",
        arguments = listOf(
            navArgument(
                name = "id"
            ){
                type = NavType.StringType
            },
            navArgument(
                name = "shouldShowKeyboard"
            ){
                type = NavType.BoolType
                defaultValue = false
            }
        )){
        EventDetailScreen(snackbarHostState = snackbarHostState )
    }
    composable(Screen.MainFeedScreen.route){
        MainFeedScreen(
            snackbarHostState = snackbarHostState,
            onNavigate = navController::navigate,
            onNavigateUp = navController::navigateUp
            )
    }
    composable(Screen.TestScreen.route){
        TestScreen(navController = navController)
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

