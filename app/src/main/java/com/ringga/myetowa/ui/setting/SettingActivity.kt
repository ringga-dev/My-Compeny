package com.ringga.myetowa.ui.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ringga.myetowa.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.swPindah.setOnClickListener {
            val switchState: Boolean = binding.swPindah.isChecked
            if (switchState == true){
                binding.viewToken.visibility = View.VISIBLE
                binding.viewUser.visibility = View.GONE
            }else{
                binding.viewToken.visibility = View.GONE
                binding.viewUser.visibility = View.VISIBLE
            }
        }

    }
}