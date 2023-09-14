package com.omrilhn.eventifyappalpha.presentation.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceMedium

@Composable
fun NotificationsScreen(navController: NavController,
                        state:SnackbarHostState){
    Box(modifier = Modifier.fillMaxSize().padding(SpaceMedium),
        contentAlignment = Alignment.Center){
            Text(text = "CampaignScreen",
                modifier = Modifier.fillMaxWidth())
    }
}