package com.ringga.myetowa.ui.menu_home.about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringga.myetowa.databinding.ActivityAboutBinding
import com.ringga.myetowa.ui.menu_home.about.fm.AboutFragment
import com.ringga.myetowa.ui.menu_home.about.fm.FisiMisiFragment
import com.ringga.myetowa.ui.menu_home.about.fm.ImageEtowaFragment
import com.ringga.myetowa.ui.menu_home.about.fm.RatingFragment

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("fragment")

        when (message) {
            "about" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, AboutFragment()
//                            .newInstance()
                    )
                    .commitNow()
            }

            "fisimisi" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, FisiMisiFragment()
//                            .newInstance()
                    )
                    .commitNow()
            }

            "imageetowa" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, ImageEtowaFragment()
//                            .newInstance()
                    )
                    .commitNow()
            }
            "ratingetowa" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, RatingFragment()
//                            .newInstance()
                    )
                    .commitNow()
            }
        }
    }
}