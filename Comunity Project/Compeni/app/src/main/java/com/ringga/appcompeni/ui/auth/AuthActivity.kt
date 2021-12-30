package com.ringga.appcompeni.ui.auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.ringga.appcompeni.databinding.ActivityAuthBinding
import com.ringga.appcompeni.ui.home.HomeActivity

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.login.setOnClickListener {
            val email = binding.edMail.text.toString().trim()
            val passw = binding.edPass.text.toString().trim()
            // cek Error
//            if (email.isEmpty()) {
//                binding.tfEmail.error = "Email Belum di isi"
//                return@setOnClickListener
//            } else {
//                binding.tfEmail.error = null
//            }
//
//            if (passw.isEmpty()) {
//                binding.tfPass.error = "Password Belum di isi"
//                return@setOnClickListener
//            } else {
//                binding.tfPass.error = null
//            }


            //melakukan pengecekan pada login

            startActivity(Intent(this, HomeActivity::class.java))
            Animatoo.animateShrink(this);//animasi onclik
            Animatoo.animateFade(this);//animasi onclik
            // close this activity
            finish()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        Animatoo.animateShrink(this) //fire the slide left animation
    }
}