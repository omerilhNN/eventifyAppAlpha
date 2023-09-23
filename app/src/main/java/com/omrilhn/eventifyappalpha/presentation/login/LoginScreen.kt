package com.omrilhn.eventifyappalpha.presentation.login

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
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
import com.omrilhn.eventifyappalpha.core.presentation.components.StandardTextField
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceLarge
import com.omrilhn.eventifyappalpha.presentation.theme.SpaceMedium


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit = {},
    loginState:LoginState,
    authViewModel:AuthenticationViewModel = hiltViewModel(),
    onLoginClick: () -> Unit
) {
    // **********************************************\\
    val emailText by viewModel.emailText.collectAsState()
    val passwordText by viewModel.passwordText.collectAsState()
    val phoneOtpText by authViewModel.phoneNumberOtp.collectAsState()
    val phoneNumberText by authViewModel.phoneNumberText.collectAsState()

    val context = LocalContext.current

    LaunchedEffect(key1 = loginState.loginError){//If sign in error value changes -> exec. coroutineScope
        loginState.loginError?.let { error-> //if loginError is not null then do these
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    fun Context.findActivity(): Activity? = when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }
    LaunchedEffect(Unit) {
        val activity = context.findActivity() ?: return@LaunchedEffect
        authViewModel.setActivity(activity)
    }


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

                //Phone number field
               StandardTextField(text = phoneNumberText,
                   onValueChange = {
                       authViewModel.setPhoneNumberText(it)
                   }, keyboardType = KeyboardType.Phone
                   ,error = viewModel.phoneError.value
                   ,hint = stringResource(id = R.string.phone_hintTR))

                Spacer(modifier = Modifier.height(SpaceMedium))

                //Password field
                StandardTextField(text = phoneOtpText,
                    onValueChange = {
//                        viewModel.setPasswordText(it)
                        authViewModel.setPhoneOtpText(it)
                    },
                    error = viewModel.passwordError.value,
                    hint = stringResource(id = R.string.passwordTR ),
                    keyboardType = KeyboardType.Password,
                    isPasswordVisible = viewModel.showPassword.value,
                    onPasswordToggleClick = {
                        viewModel.setShowPassword(it)
                    })

                Spacer(modifier = Modifier.height(SpaceMedium))


                //Also manage Google sign in with onLoginClick parameter when you call this LoginScreen composable fun
                Button(
                    onClick = onLoginClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ){
                    Text(text = stringResource(id = R.string.loginTR),
                        color = MaterialTheme.colorScheme.onPrimary)
                }

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
                        com.omrilhn.eventifyappalpha.utils.Screen.RegisterScreen.route
                    )
                }
        )
            }
        }

