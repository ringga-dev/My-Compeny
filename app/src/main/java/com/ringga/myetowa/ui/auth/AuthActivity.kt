package com.ringga.myetowa.ui.auth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ringga.myetowa.databinding.ActivityAuthBinding
import com.ringga.myetowa.ui.auth.fragment.LoginFragment
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.ringga.myetowa.R
import com.ringga.myetowa.data.database.SharedPrefManager
import com.ringga.myetowa.ui.auth.fragment.RegisterFragment
import com.ringga.myetowa.ui.home.HomeActivity
import com.ringga.myetowa.ui.setting.SettingActivity
import com.ringga.security.util.chage_color_stts_bar
import com.ringga.security.util.snackbar
import com.ringga.security.util.toast
import java.io.File
import java.io.FileInputStream


class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    private var scaledown: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        chage_color_stts_bar(window, "#90f0ee")

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, LoginFragment.newInstance())
                .commitNow()
        }
        scaledown = AnimationUtils.loadAnimation(
            this,
            R.anim.scale_down_button
        )

        binding.btnSetting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
            binding.btnSetting.startAnimation(scaledown)
        }

        binding.btnLogin.setOnClickListener {

            tulisFile(it)

            binding.btnLogin.startAnimation(scaledown)

            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, LoginFragment.newInstance())
                .commitNow()
        }

        binding.btnRegister.setOnClickListener {
            binding.btnRegister.startAnimation(scaledown)
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, RegisterFragment.newInstance())
                .commitNow()
        }

    }

    private fun tulisFile(view:View) {
        val path = this.filesDir
        //external tempat penyimpanan nya
        //val path = this.getExternalFilesDir(null)

        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()

        val file = File(letDirectory, "Simpan.txt")
        file.appendText("Url dan token save")

//        toast(this, "save sucess")
        val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }

        toast(this,inputAsString)
        Toast.makeText(this, path.path, Toast.LENGTH_SHORT).show()


    }

    override fun onResume() {
        super.onResume()
        if(SharedPrefManager.getInstance(this).isLoggedIn){
            startActivity(Intent(this, HomeActivity::class.java)).also {
                finish()
            }
        }
    }
}