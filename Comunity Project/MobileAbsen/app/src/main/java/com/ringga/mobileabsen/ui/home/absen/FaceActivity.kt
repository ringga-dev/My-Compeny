package com.ringga.mobileabsen.ui.home.absen


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.ringga.mobileabsen.databinding.ActivityFaceBinding
import com.ringga.mobileabsen.ui.auth.AuthActivity
import java.util.concurrent.Executor


class FaceActivity : AppCompatActivity() {


    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo


    private lateinit var binding: ActivityFaceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaceBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnscan.setOnClickListener {
            sidikjari(this ,this)
//            sidikjari()
        }

    }

    private  fun sidikjari(){
        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int,
                                                   errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(applicationContext,
                        "$errString", Toast.LENGTH_SHORT)
                        .show()

                    startActivity(Intent(this@FaceActivity, AuthActivity::class.java))
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(applicationContext,
                        "Autentikasi berhasil", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(applicationContext, "Autentikasi gagal!",
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


}
