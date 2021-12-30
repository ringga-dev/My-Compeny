package com.ringga.mobileabsen.ui.home.absen

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.ringga.mobileabsen.ui.auth.AuthActivity
import java.util.concurrent.Executor

private lateinit var executor: Executor
private lateinit var biometricPrompt: BiometricPrompt
private lateinit var promptInfo: BiometricPrompt.PromptInfo

fun sidikjari(context: Context ,fcontex:FragmentActivity){

    executor = ContextCompat.getMainExecutor(context)
    biometricPrompt = BiometricPrompt(fcontex, executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int,
                                               errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(context,
                    "$errString", Toast.LENGTH_SHORT)
                    .show()

                context.startActivity(Intent(context, AuthActivity::class.java))
            }

            override fun onAuthenticationSucceeded(
                result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(context,
                    "Autentikasi berhasil", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(context, "Autentikasi gagal!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        })

    promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("biometric check")
        .setSubtitle("lakukan scan sidik jari untuk melanjutkan")
        .setNegativeButtonText("Use Login")
        .build()

    // Prompt appears when user clicks "Log in".
    // Consider integrating with the keystore to unlock cryptographic operations,
    // if needed by your app.
    biometricPrompt.authenticate(promptInfo)
}