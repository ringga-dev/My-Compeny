package com.ringga.myetowa.ui.home

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringga.myetowa.databinding.ActivityHomeBinding
import com.ringga.myetowa.ui.auth.fragment.LoginFragment
import com.ringga.myetowa.ui.home.fragment.HomeMenuFragment
import com.ringga.security.util.chage_color_stts_bar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, HomeMenuFragment.newInstance())
                .commitNow()
        }

        chage_color_stts_bar(window,"#0097A7")
    }
}