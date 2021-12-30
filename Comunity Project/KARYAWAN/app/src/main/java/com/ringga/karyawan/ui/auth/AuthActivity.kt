package com.ringga.karyawan.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringga.karyawan.R
import com.ringga.karyawan.databinding.AuthActivityBinding
import com.ringga.karyawan.ui.auth.fragmen.LoginFragment

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: AuthActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AuthActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                LoginFragment.newInstance()
            ).commit()

    }



}