package com.omrilhn.eventifyappalpha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.omrilhn.eventifyappalpha.presentation.theme.EventifyAppAlphaTheme
import com.omrilhn.eventifyappalpha.presentation.utils.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventifyAppAlphaTheme {
                Navigation()
            //EventifyApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventifyAppAlphaTheme {
    Navigation()
    //        EventifyApp()
    }
}