package com.omrilhn.eventifyappalpha.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.components.HeadingTextComponent
import com.omrilhn.eventifyappalpha.navigation.BackButtonHandler
import com.omrilhn.eventifyappalpha.navigation.EventifyAppRouter
import com.omrilhn.eventifyappalpha.navigation.Screen

@Composable
fun TermsAndConditionsScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)){
        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_headingTR))

        BackButtonHandler{
            EventifyAppRouter.navigateTo(Screen.SignUpScreen)

        }


    }
}
@Preview
@Composable
fun TermsAndConditionsScreenPreview(){
    TermsAndConditionsScreen()
}