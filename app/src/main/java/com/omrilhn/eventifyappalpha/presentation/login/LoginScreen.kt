package com.omrilhn.eventifyappalpha.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.components.DividerTextComponent
import com.omrilhn.eventifyappalpha.navigation.Screen
import com.omrilhn.eventifyappalpha.presentation.components.StandardTextField
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceLarge
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceMedium


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    // **********************************************\\
    val usernameText by viewModel.emailText.collectAsState()
    val passwordText by viewModel.passwordText.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpaceMedium)
                    .align(Alignment.Center)) {
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

                Spacer(modifier = Modifier.height(SpaceMedium))

                //Username field
               StandardTextField(text = usernameText,
                   onValueChange = {
                       viewModel.setEmailText(it)
                   }, error = viewModel.emailError.value
                   ,hint = stringResource(id = R.string.login_hintTR))

                Spacer(modifier = Modifier.height(SpaceMedium))

                //Password field
                StandardTextField(text = passwordText,
                    onValueChange = {
                        viewModel.setPasswordText(it)

                    },
                    error = viewModel.passwordError.value,
                    hint = stringResource(id = R.string.passwordTR ),
                    keyboardType = KeyboardType.Password,
                    isPasswordVisible = viewModel.showPassword.value,
                    onPasswordToggleClick = {
                        viewModel.setShowPassword(it)
                    })

                Spacer(modifier = Modifier.height(SpaceMedium))

                Button(
                    onClick = {},
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ){
                    Text(text = stringResource(id = R.string.loginTR),
                        color = MaterialTheme.colorScheme.onPrimary)


                }

//                UnderlinedTextComponent(value = stringResource(id = R.string.forgot_passwordTR))
//                Spacer(modifier = Modifier.height(20.dp))
//                ButtonComponent(
//                    value = stringResource(id = R.string.loginTR),
//                    onButtonClicked = {
//                        //call viewmodel
//                    })
                DividerTextComponent()
//                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
//                    EventifyAppRouter.navigateTo(Screen.SignUpScreen)
//
//                })
                }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_an_account_yetTR))
                append(" ")
                val signUpText = stringResource(id = R.string.registerTR)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary
                    )
                ) {
                    append(signUpText)
                }
            },
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(
                        Screen.RegisterScreen.route
                    )
                }
        )
            }

        }
//    BackButtonHandler {
//        EventifyAppRouter.navigateTo(Screen.SignUpScreen)
//    }
