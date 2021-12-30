package com.ringga.karyawan.pekerjaan

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun snackbar(text :String, view: View){
    Snackbar.make(view, text, Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()
}

fun toals(context: Context, text: String){
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

