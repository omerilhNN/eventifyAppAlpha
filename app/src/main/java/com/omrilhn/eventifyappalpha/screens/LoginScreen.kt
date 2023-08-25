package com.omrilhn.eventifyappalpha.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.components.ButtonComponent
import com.omrilhn.eventifyappalpha.components.ClickableLoginTextComponent
import com.omrilhn.eventifyappalpha.components.DividerTextComponent
import com.omrilhn.eventifyappalpha.components.InputTextField
import com.omrilhn.eventifyappalpha.components.PasswordTextField
import com.omrilhn.eventifyappalpha.components.UnderlinedTextComponent
import com.omrilhn.eventifyappalpha.model.UserInfo
import com.omrilhn.eventifyappalpha.navigation.BackButtonHandler
import com.omrilhn.eventifyappalpha.navigation.EventifyAppRouter
import com.omrilhn.eventifyappalpha.navigation.Screen
import com.omrilhn.eventifyappalpha.network.RestApiManager

@Composable
fun LoginScreen() {
    val restApiManager = RestApiManager()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stay_eventified),
                        contentDescription = "Eventify Logo",
                        modifier = Modifier
                            .height(150.dp)
                            .width(150.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                InputTextField(
                    labelValue = stringResource(id = R.string.emailTR),
                    imageResource = Icons.Rounded.AccountBox, modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                PasswordTextField(
                    labelValue = stringResource(id = R.string.passwordTR),
                    imageResource = Icons.Rounded.Lock, modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(40.dp))

                UnderlinedTextComponent(value = stringResource(id = R.string.forgot_passwordTR))
                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.loginTR),
                    onButtonClicked = {
                        //call viewmodel
                    })
                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    EventifyAppRouter.navigateTo(Screen.SignUpScreen)

                })
            }

            }

        }
//    BackButtonHandler {
//        EventifyAppRouter.navigateTo(Screen.SignUpScreen)
//    }
}
@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}