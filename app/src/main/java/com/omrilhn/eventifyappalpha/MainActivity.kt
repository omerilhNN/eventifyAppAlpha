package com.omrilhn.eventifyappalpha

import com.omrilhn.eventifyappalpha.core.presentation.components.StandardScaffold
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.omrilhn.eventifyappalpha.presentation.theme.EventifyAppAlphaTheme
import com.omrilhn.eventifyappalpha.core.presentation.components.Navigation
import com.omrilhn.eventifyappalpha.network.EventApiService
import com.omrilhn.eventifyappalpha.utils.Screen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var imageLoader : ImageLoader


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventifyAppAlphaTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val snackbarHostState = remember {SnackbarHostState()}

                    StandardScaffold(
                        navController = navController,
                        showBottomBar = shouldShowBottomBar(navBackStackEntry),
                        modifier = Modifier.fillMaxSize(),
                        onFabClick = { //FloatingActionButton clicked
                            navController.navigate(Screen.MainFeedScreen.route)
                        },
                        state = snackbarHostState
                    ) {
                        //Imageloader removed
                        Navigation(navController, snackbarHostState,imageLoader)
                    }
                }
            }
    }
}
    private fun shouldShowBottomBar(backStackEntry: NavBackStackEntry?): Boolean {
        val doesRouteMatch = backStackEntry?.destination?.route in listOf(//If current destination is in that list then should show bottom bar
            Screen.MainFeedScreen.route,
            Screen.CampaignScreen.route,
            Screen.MyActivitiesScreen.route,
            Screen.NotificationsScreen.route,
            Screen.ProfileScreen.route
        )
        val isOwnProfile = backStackEntry?.destination?.route == "${Screen.ProfileScreen.route}?userId={userId}" &&
                backStackEntry.arguments?.getString("userId") == null
        return doesRouteMatch || isOwnProfile
    }

}


