package com.ringga.myetowa

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ringga.myetowa.databinding.ActivityMainBinding
import com.ringga.myetowa.ui.auth.AuthActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.githubIcon.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/ringga-dev")
            startActivity(openURL)
        }
        val sdf = SimpleDateFormat("dd-M-yyyy")
        val currentDate = sdf.format(Date())

        binding.tvDate.text = "Made with ❤️ from Indonesia \n $currentDate"

        Handler().postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }, 4500)

//        Snackbar.make(binding.root, "We changes app background color.", Snackbar.LENGTH_LONG).setAction("Undo") {
//
//            startActivity(Intent(this, AuthActivity::class.java))
//            val snackbar = Snackbar.make(
//                binding.root,
//                "This is a styled snack bar.",
//                Snackbar.LENGTH_INDEFINITE
//            )
//
//            val snack_root_view = snackbar.view
//            val snack_text_view = snack_root_view
//                .findViewById<TextView>(R.id.snackbar_text)
//            val snack_action_view = snack_root_view
//                .findViewById<Button>(R.id.snackbar_action)
//            snack_root_view.setBackgroundColor(Color.parseColor("#FFCFBEB4"))
//            snack_text_view.setTextColor(Color.RED)
//            snack_text_view.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC)
//            snack_action_view.setTextColor(Color.YELLOW)
//            snackbar.setAction("Hide Me") {
//                snackbar.dismiss()
//            }
//
//            snackbar.show()
//        }.show()
    }
}