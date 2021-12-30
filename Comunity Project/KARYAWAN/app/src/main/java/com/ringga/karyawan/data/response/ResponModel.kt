package com.ringga.karyawan.data.response

data class ResponWilayah(val wilayah: String)

data class ResponCuaca(
    val kota: String,
    val pagi: String,
    val siang: String,
    val malam: String,
    val dini_hari: String,
    val suhu: String,
    val kelembaban: String
)

data class ResponGempa(
    val stts: String,
    val tgl: String,
    val jam: String,
    val lintang: String,
    val bujur: String,
    val kedalaman: String,
    val m: String,
    val mt: String,
    val region: String
)