package com.omrilhn.eventifyappalpha.utils

sealed class Screen(val route:String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object VerificationScreen : Screen("verification_screen")
    object MainFeedScreen : Screen("main_feed_screen")
    object MyActivitiesScreen : Screen("my_activities_screen")
    object PersonalDetail : Screen("personal_detail_screen")

    object CampaignScreen : Screen("campaign_screen")
    object NotificationsScreen : Screen("notifications_screen")
    object ProfileScreen : Screen("profile_screen")


    object EventDetailScreen : Screen("event_detail_screen")
    object MessagesScreen : Screen("messages_screen")
    object SearchScreen : Screen("search_screen")
    object ChatScreen : Screen("chat_screen")
    object EditProfileScreen : Screen("edit_profile_screen")


}