package com.ringga.myetowa.ui.menu_home.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringga.myetowa.R
import com.ringga.myetowa.databinding.ActivityUserBinding
import com.ringga.myetowa.ui.auth.fragment.LoginFragment
import com.ringga.myetowa.ui.menu_home.AboutEtowaFragment
import com.ringga.myetowa.ui.menu_home.ProductMenuFragment
import com.ringga.myetowa.ui.menu_home.user.fm.ChageImageFragment
import com.ringga.myetowa.ui.menu_home.user.fm.ChagePasswordFragment
import com.ringga.myetowa.ui.menu_home.user.fm.EditProfileFragment
import com.ringga.myetowa.ui.menu_home.user.fm.MyProfileFragment

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("fragment")

        when (message) {
            "myprofile" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, MyProfileFragment()
//                            .newInstance()
                    )
                    .commitNow()
            }

            "chagepassword" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, ChagePasswordFragment()
//                            .newInstance()
                    )
                    .commitNow()
            }

            "editprofile" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, EditProfileFragment()
//                            .newInstance()
                    )
                    .commitNow()
            }
            "chageimage" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, ChageImageFragment()
//                            .newInstance()
                    )
                    .commitNow()
            }

        }
    }
}