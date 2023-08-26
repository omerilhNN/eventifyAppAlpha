package com.omrilhn.eventifyappalpha.presentation.login

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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.components.ButtonComponent
import com.omrilhn.eventifyappalpha.components.ClickableLoginTextComponent
import com.omrilhn.eventifyappalpha.components.DividerTextComponent
import com.omrilhn.eventifyappalpha.components.InputTextField
import com.omrilhn.eventifyappalpha.components.PasswordTextField
import com.omrilhn.eventifyappalpha.components.UnderlinedTextComponent
import com.omrilhn.eventifyappalpha.navigation.EventifyAppRouter
import com.omrilhn.eventifyappalpha.navigation.Screen
import com.omrilhn.eventifyappalpha.network.RestApiManager
import com.omrilhn.eventifyappalpha.presentation.components.StandardTextField
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceMedium


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    // **********************************************\\
    val usernameText by viewModel.usernameText.collectAsState()
    val passwordText by viewModel.passwordText.collectAsState()

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

               StandardTextField(text = usernameText,
                   onValueChange = {
                       viewModel.setUsernameText(it)
                   },hint = stringResource(id = R.string.login_hintTR))
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(text = passwordText,
                    onValueChange = {
                        viewModel.setPasswordText(it)

                    },
                    hint = stringResource(id = R.string.passwordTR ),
                    keyboardType = KeyboardType.Password
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
