package com.ringga.karyawan.ui.lingkungan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringga.karyawan.databinding.ActivityGempaBinding

class GempaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGempaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGempaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}