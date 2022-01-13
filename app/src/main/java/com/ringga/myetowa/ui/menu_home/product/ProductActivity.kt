package com.ringga.myetowa.ui.menu_home.product


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringga.myetowa.databinding.ActivityProductBinding
import com.ringga.myetowa.ui.menu_home.product.fm.*

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("fragment")

        when (message) {
            "order" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, OrderFragment.newInstance()
                    ).commitNow()
            }
            "approved" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, ApprovedFragment.newInstance()
                    ).commitNow()
            }
            "reject" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, RejectFragment.newInstance()
                    ).commitNow()
            }
            "ordering" -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, OrderingFragment.newInstance()
                    ).commitNow()
            }
            "take" ->{
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, TakeFragment.newInstance()
                    ).commitNow()
            }
            "orderSuccess" ->{
                supportFragmentManager.beginTransaction()
                    .replace(
                        binding.container.id, OrderSuccessFragment.newInstance()
                    ).commitNow()
            }

        }
    }
}