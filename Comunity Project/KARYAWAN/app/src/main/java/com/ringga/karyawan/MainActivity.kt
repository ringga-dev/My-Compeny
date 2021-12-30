package com.ringga.karyawan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.ringga.karyawan.databinding.ActivityMainBinding
import com.ringga.karyawan.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textAppBy.setOnClickListener {
            val url = "https://github.com/ringga-dev"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        Handler().postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            Animatoo.animateShrink(this);//animasi onclik
            Animatoo.animateFade(this);//animasi onclik
            finish()
        }, 3000)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Animatoo.animateShrink(this) //fire the slide left animation
    }
}