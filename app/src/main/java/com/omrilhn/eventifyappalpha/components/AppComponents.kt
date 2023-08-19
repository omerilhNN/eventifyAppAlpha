package com.omrilhn.eventifyappalpha.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.ui.theme.BgColor
import com.omrilhn.eventifyappalpha.ui.theme.GrayColor
import com.omrilhn.eventifyappalpha.ui.theme.Primary
import com.omrilhn.eventifyappalpha.ui.theme.Secondary
import com.omrilhn.eventifyappalpha.ui.theme.TextColor

@Composable
fun NormalTextComponent(value:String){
    Text(text = value
        ,modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}@Composable
fun UnderlinedTextComponent(value:String){
    Text(text = value
        ,modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}
@Composable
fun HeadingTextComponent(value:String){
    Text(text = value
        ,modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(labelValue:String, imageResource: ImageVector, modifier: Modifier = Modifier){
    val textValue = remember {
        mutableStateOf(" ")
    }
    TextField(modifier = modifier
        .widthIn(min = 150.dp)
        .heightIn(min = 25.dp)
        ,label = {
            Text(text = labelValue, textAlign = TextAlign.Center, fontSize = 16.sp, softWrap = true
        )
        },
        colors = TextFieldDefaults.textFieldColors(

            focusedLabelColor = Primary,
            focusedIndicatorColor = Primary,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine=true,
        maxLines =  1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(imageVector = imageResource , contentDescription = "")        },


        )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue:String, imageResource: ImageVector, modifier: Modifier = Modifier){

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember{
        mutableStateOf(false)
    }
    TextField(modifier = modifier
        .widthIn(min = 150.dp)
        .heightIn(min = 25.dp)
        ,label = {
            Text(text = labelValue, textAlign = TextAlign.Center, fontSize = 16.sp, softWrap = true
        )
        },
        colors = TextFieldDefaults.textFieldColors(

            focusedLabelColor = Primary,
            focusedIndicatorColor = Primary,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        },
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(imageVector = imageResource , contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            val description = if(passwordVisible.value){
                stringResource(id = R.string.hide_passwordTR)
            }else {
                stringResource(id = R.string.show_passwordTR)
            }
            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value }){
                Icon(imageVector = iconImage, contentDescription =description )
            }
        }, visualTransformation = if(passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}
@Composable
fun CheckBoxComponent(value: String,onTextSelected: (String) -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        val checkedState = remember{
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = !checkedState.value
        })
        ClickableTextComponent(value = value,onTextSelected)
    }
}
@Composable
fun ClickableTextComponent(value:String, onTextSelected: (String) -> Unit)
{
    val initialText = "Devam ederek "
    val privacyPolicyText = "Gizlilik Politikamızı"
    val andText = " ve "
    val termsofUseText = "Kullanım Koşullarımızı "
    val acceptText = "kabul etmiş oluyorsunuz."

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style= SpanStyle(color = Primary)){
            pushStringAnnotation(tag = privacyPolicyText,annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = termsofUseText, annotation = termsofUseText)
            append(termsofUseText)
        }
        append(acceptText)
    }

    ClickableText(text = annotatedString, onClick ={offset->
        //CHECK OUT WHICH PART OF THE STRING THAT WE HAVE CLICKED
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                //Go to clicked POLICY TEXT
                Log.d("ClickableTextComponnet","{$span}")

                if((span.item== termsofUseText) || (span.item == privacyPolicyText)){
                    onTextSelected(span.item)
                }
            }

    } )
}
@Composable
fun ClickableLoginTextComponent(tryingToLogin:Boolean =true,onTextSelected: (String) -> Unit)
{
    val initialText = if(tryingToLogin)"Zaten hesabınız var mı?" else "Hala hesabınız yok mu?"
    val loginText = if(tryingToLogin)"Giriş yap" else "Kayıt ol"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style= SpanStyle(color = Primary)){
            pushStringAnnotation(tag = loginText,annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick ={offset->
            //CHECK OUT WHICH PART OF THE STRING THAT WE HAVE CLICKED
            annotatedString.getStringAnnotations(offset,offset)
                .firstOrNull()?.also {span->
                    //Go to clicked POLICY TEXT
                    Log.d("ClickableTextComponnet","{$span}")

                    if((span.item== loginText)){
                        onTextSelected(span.item)
                    }
                }

        } )
}

@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        onClick = {
            onButtonClicked.invoke()
        },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }
    }
}
@Composable
fun DividerTextComponent(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.other_loginOptionsTR),
            fontSize = 18.sp,
            color = TextColor
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}
