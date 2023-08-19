package com.omrilhn.eventifyappalpha.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.components.CheckBoxComponent
import com.omrilhn.eventifyappalpha.components.ClickableLoginTextComponent
import com.omrilhn.eventifyappalpha.components.DividerTextComponent
import com.omrilhn.eventifyappalpha.components.InputTextField
import com.omrilhn.eventifyappalpha.components.PasswordTextField
import com.omrilhn.eventifyappalpha.navigation.EventifyAppRouter
import com.omrilhn.eventifyappalpha.navigation.Screen

@Composable
fun SignUpScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .background(Color.White)){
        Column(modifier = Modifier.padding(8.dp)){
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center){
                Image(painter = painterResource(id = R.drawable.stay_eventified),
                    contentDescription ="Eventify Logo",
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp))
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)) {
                InputTextField(labelValue = stringResource(id = R.string.first_nameTR),
                    imageResource = Icons.Rounded.AccountBox)
                Spacer(modifier = Modifier.width(10.dp))
                InputTextField(labelValue = stringResource(id = R.string.last_nameTR)
                    ,imageResource = Icons.Rounded.AccountBox)
            }

            InputTextField(labelValue = stringResource(id = R.string.emailTR)
                ,imageResource = Icons.Rounded.MailOutline)

            Spacer(modifier = Modifier.height(20.dp))

            PasswordTextField(labelValue = stringResource(id = R.string.passwordTR)
                ,imageResource = Icons.Rounded.Lock,modifier = Modifier
                    .fillMaxWidth(1f)
                    .align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(20.dp))

            CheckBoxComponent(value = stringResource(id = R.string.terms_and_conditionsTR),
                onTextSelected = {
                    EventifyAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                })
            Spacer(modifier = Modifier.height(80.dp))
//            ButtonComponent(value = stringResource(R.string.registerTR)
//                )
            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = true,onTextSelected = {
                EventifyAppRouter.navigateTo(Screen.LoginScreen)
            })
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}