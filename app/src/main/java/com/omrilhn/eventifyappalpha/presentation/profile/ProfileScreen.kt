package com.omrilhn.eventifyappalpha.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import com.omrilhn.eventifyappalpha.core.presentation.components.StandardToolbar
import com.omrilhn.eventifyappalpha.presentation.theme.ProfilePictureSizeLarge
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceMedium

@Composable
fun ProfileScreen(
    navController:NavController,
    state:SnackbarHostState,
    imageLoader:ImageLoader,
    userId:String?=null,
    onNavigate: (String) -> Unit = {},
    onLogout:() -> Unit = {},
    profilePictureSize: Dp = ProfilePictureSizeLarge,
    viewModel: ProfileViewModel = hiltViewModel()

    ){
    Column(modifier = Modifier.fillMaxSize()){
        StandardToolbar()
    }
}