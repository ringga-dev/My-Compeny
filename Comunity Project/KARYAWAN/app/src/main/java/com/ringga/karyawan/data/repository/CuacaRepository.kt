package com.ringga.karyawan.data.repository

import com.ringga.karyawan.data.api.RetrofitClient


class CuacaRepository constructor(private val retrofitService: RetrofitClient) {

    suspend fun getcuaca(menu:String, wilayah:String) = retrofitService.instance.wilayah(menu, wilayah)

}