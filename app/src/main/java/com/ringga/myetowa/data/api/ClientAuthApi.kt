package com.ringga.myetowa.data.api

import android.util.Base64
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientAuthApi {
    const val BASE_URL = "http://192.168.0.144/ci-assets/public/"

    val instance: RoleApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(RoleApi::class.java)
    }
}