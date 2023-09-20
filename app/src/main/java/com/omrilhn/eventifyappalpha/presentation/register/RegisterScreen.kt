package com.omrilhn.eventifyappalpha.presentation.register

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
import androidx.compose.runtime.LaunchedEffect
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
import com.omrilhn.eventifyappalpha.model.UserInfo
import com.omrilhn.eventifyappalpha.core.presentation.components.StandardTextField
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceLarge
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceMedium
import kotlinx.coroutines.DelicateCoroutinesApi

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel:RegisterViewModel = hiltViewModel()
){
    val emailText by viewModel.emailText.collectAsState()
    val passwordText by viewModel.passwordText.collectAsState()
    val nameText by viewModel.nameText.collectAsState()
    val surnameText by viewModel.surnameText.collectAsState()
    val userInfo = UserInfo(emailText,passwordText,true,"")



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceMedium,
                end = SpaceMedium,
                top = SpaceLarge,
                bottom = 50.dp
            )
            ){
        Column(verticalArrangement =Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
                .align(Alignment.Center)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.stay_eventified),
                    contentDescription = "Eventify Logo",
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {
                StandardTextField(text = nameText,
                    onValueChange = {
                        viewModel.setNameText(it)
                    },
                    hint = stringResource(id = R.string.first_nameTR),
                    modifier = Modifier.fillMaxWidth(0.5f))

                Spacer(modifier = Modifier.width(10.dp))

                StandardTextField(text = surnameText,
                    onValueChange = {
                        viewModel.setSurnameText(it)
                    },
                    error = viewModel.emailError.value,
                    hint = stringResource(id = R.string.last_nameTR),
                    modifier = Modifier.fillMaxWidth())

            }
            //EMAIL FIELD
            StandardTextField(
                text = emailText,
                onValueChange = {
                    viewModel.setEmailText(it)
                }, keyboardType = KeyboardType.Email,
                error = viewModel.emailError.value,
                hint = stringResource(id = R.string.emailTR)
            )


            Spacer(modifier = Modifier.height(20.dp))
            //PASSWORD FIELD
            StandardTextField(text = passwordText,
                onValueChange = {
                    viewModel.setPasswordText(it)
                },
                error = viewModel.passwordError.value,
                hint = stringResource(id = R.string.passwordTR),
                keyboardType = KeyboardType.Password,
                isPasswordVisible = viewModel.showPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassword(it)
                })

            Spacer(modifier = Modifier.height(20.dp))

//            CheckBoxComponent(value = stringResource(id = R.string.terms_and_conditionsTR),
//                onTextSelected = {
//                    EventifyAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
//                })
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {

                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = R.string.registerTR),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

        }
            Text(
                text = buildAnnotatedString {
                    append(stringResource(id = R.string.already_have_account))
                    append(" ")
                    val signUpText = stringResource(id = R.string.loginTR)
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
                        navController.popBackStack()
                    }
            )

        }
    }


