package com.omrilhn.eventifyappalpha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.omrilhn.eventifyappalpha.presentation.theme.EventifyAppAlphaTheme
import com.omrilhn.eventifyappalpha.utils.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                    val scaffoldState = rememberSca

                    StandardScaffold(
                        navController = navController,
                        showBottomBar = shouldShowBottomBar(navBackStackEntry),
                        state = scaffoldState,
                        modifier = Modifier.fillMaxSize(),
                        onFabClick = {
                            navController.navigate()
                        }
                    ) {
                        Navigation(navController, scaffoldState, imageLoader)
                    }
                }
            }
    }
}


