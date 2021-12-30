package com.ringga.appcompeni.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringga.appcompeni.R
import com.ringga.appcompeni.ui.home.fragment.HomeMenuFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeMenuFragment.newInstance())
                .commitNow()
        }
    }
}