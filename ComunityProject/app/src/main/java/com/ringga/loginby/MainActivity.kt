package com.ringga.loginby

import android.accounts.Account
import android.accounts.AccountManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ringga.loginby.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val am: AccountManager = AccountManager.get(this) // "this" references the current Context

//        val accounts: Array<out Account> = am.getAccountsByType("com.google")
//        var text = ""
//
//        accounts.forEach {
//            text = text + "\n" + it.name
//        }
//        binding.tvView.text = text
        Toast.makeText(this, am.accounts[0].name, Toast.LENGTH_SHORT).show()
    }
}