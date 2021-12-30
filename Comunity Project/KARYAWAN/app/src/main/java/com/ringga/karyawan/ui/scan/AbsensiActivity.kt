package com.ringga.karyawan.ui.scan

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.ResultPoint
import com.google.zxing.client.android.BeepManager
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.CaptureManager
import com.ringga.karyawan.R
import com.ringga.karyawan.databinding.ActivityAbsensiBinding
import kotlinx.android.synthetic.main.activity_absensi.*
import kotlinx.android.synthetic.main.costum_scan.*
import java.util.*

class AbsensiActivity : AppCompatActivity() {

    private lateinit var captureManager: CaptureManager
    private var torchState: Boolean = false

    private var scanContinuousState: Boolean = false
    private lateinit var scanContinuousBG: Drawable
    lateinit var beepManager: BeepManager
    private var lastScan = Date()


    private lateinit var binding: ActivityAbsensiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbsensiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Continuous Scan"

        captureManager = CaptureManager(this, barcodeView)
        captureManager.initializeFromIntent(intent, savedInstanceState)


        var callback = object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                result?.let {
                    val current = Date()
//                    txtResultContinuous.text = it.text //menyimpan data ke text
                    lastScan = current
                    animateBackground()
                }
            }

            override fun possibleResultPoints(resultPoints: MutableList<ResultPoint>?) {
            }
        }
        barcodeView.decodeContinuous(callback)


        switch_flashlight.setOnClickListener {
            if (torchState) {
                torchState = false
                barcodeView.setTorchOff()
                switch_flashlight.setBackgroundResource(R.drawable.bg_senter_off)
            } else {
                switch_flashlight.setBackgroundResource(R.drawable.bg_senter_on)
                torchState = true
                barcodeView.setTorchOn()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        captureManager.onPause()
    }

    override fun onResume() {
        super.onResume()
        captureManager.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        captureManager.onDestroy()
    }

    private fun animateBackground() {
        val colorFrom = resources.getColor(R.color.merah)
        val colorTo = resources.getColor(R.color.cremterang)
        val colorAnimation =
            ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        colorAnimation.duration = 250 // milliseconds

        colorAnimation.addUpdateListener { animator ->
            txtResultContinuous.setBackgroundColor(
                animator.animatedValue as Int
            )
        }
        colorAnimation.start()
    }
}