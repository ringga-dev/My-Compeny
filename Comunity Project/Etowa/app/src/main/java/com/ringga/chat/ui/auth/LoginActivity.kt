package com.ringga.chat.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ringga.chat.R
import com.ringga.chat.theme.EtowaTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EtowaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting2("Android")
                }
            }
        }

    }

    @Composable
    fun Greeting2(name: String) {
        val context = LocalContext.current
        val email = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        val emptyEmailError = remember { mutableStateOf(false) }
        val emptyPasswordError = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {


            Image(
                painter = painterResource(id = R.drawable.ic_logo_instagram_text),
                contentDescription = "Instagram",
                modifier = Modifier
                    .width(200.dp)
                    .align(alignment = Alignment.CenterHorizontally),
            )
            Spacer(Modifier.size(25.dp))
            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    if (emptyEmailError.value) {
                        emptyEmailError.value = false
                    }
                    email.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Email")
                },
                isError = emptyEmailError.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#0095F6")),
                    cursorColor = Color(android.graphics.Color.parseColor("#0095F6")),
                    focusedLabelColor = Color(android.graphics.Color.parseColor("#0095F6"))
                )
            )
            if (emptyEmailError.value) {
                Text(text = "Email masih kosong", color = androidx.compose.ui.graphics.Color.Red)
            }

            Spacer(Modifier.size(16.dp))
            val passwordVisibility = remember { mutableStateOf(true) }

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    if (emptyPasswordError.value) {
                        emptyPasswordError.value = false
                    }
                    password.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            imageVector = if (passwordVisibility.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = "visibility"
                        )
                    }
                },
                visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(android.graphics.Color.parseColor("#0095F6")),
                    cursorColor = Color(android.graphics.Color.parseColor("#0095F6")),
                    focusedLabelColor = Color(android.graphics.Color.parseColor("#0095F6"))
                )
            )
            if (emptyPasswordError.value) {
                Text(text = "Password masih kosong", color = androidx.compose.ui.graphics.Color.Red)
            }

            Spacer(Modifier.size(25.dp))

            Button(
                onClick = {
                    when {
                        email.value.text.isEmpty() -> {
                            emptyEmailError.value = true
                        }
                        password.value.text.isEmpty() -> {
                            emptyPasswordError.value = true
                        }
                        else -> {
                            Toast.makeText(context, "Login successfully", Toast.LENGTH_SHORT).show()
//                        context.startActivity(Intent(context, MainActivity::class.java))
                        }
                    }
                },
                content = {
                    Text(text = "Login", color = androidx.compose.ui.graphics.Color.White)
                },
                modifier = Modifier
                    .height(height = 45.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        android.graphics.Color.parseColor(
                            "#0095F6"
                        )
                    )
                )
            )

            Spacer(Modifier.size(8.dp))

            Text(
                text = "Forget your login details? Get Help logging in",
                color = androidx.compose.ui.graphics.Color.Gray,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Spacer(Modifier.size(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Divider(
                    Modifier.fillMaxWidth(0.45f),
                    color = androidx.compose.ui.graphics.Color.Gray,
                    thickness = 1.dp
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    text = "OR",
                    color = androidx.compose.ui.graphics.Color.Gray,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.size(8.dp))
                Divider(
                    Modifier.fillMaxWidth(),
                    color = androidx.compose.ui.graphics.Color.Gray,
                    thickness = 1.dp
                )
            }

            Spacer(Modifier.size(24.dp))

            Text(
                text = "Login With Facebook",
                color = Color(android.graphics.Color.parseColor("#0095F6")),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable {
                        Toast
                            .makeText(this@LoginActivity, "login dengan fb", Toast.LENGTH_SHORT)
                            .show()
                    },
            )

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = "Don't have account? Signup",
                color = androidx.compose.ui.graphics.Color.Gray,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable {
                        Toast
                            .makeText(this@LoginActivity, "membuat akun", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }

    }

    @Preview(showSystemUi = true, device = Devices.NEXUS_5X)
    @Composable
    fun DefaultPreview() {
        EtowaTheme {
            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                Greeting2(":-)")
            }
        }
    }

}








