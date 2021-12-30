package com.ringga.chat

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.airbnb.lottie.compose.*
import com.ringga.chat.theme.EtowaTheme
import com.ringga.chat.ui.auth.LoginActivity
import com.ringga.chat.ui.auth.RegisterActivity
import com.ringga.chat.ui.home.HomeActivity
import com.ringga.chat.ui.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EtowaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(true)
                }
            }
        }

    }

    @Composable
    fun Greeting(name: Boolean) {
        val context = LocalContext.current
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
        val progress by animateLottieCompositionAsState(composition, iterations = 10)
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.clickable {
                context.startActivity(Intent(context, HomeActivity::class.java))
            }
        )
    }

}


