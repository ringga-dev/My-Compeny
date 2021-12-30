package com.ringga.myetowa.data.api

import android.util.Base64
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ClientApi {

    private val AUTH =
        "Basic " + Base64.encodeToString("ringga:123456".toByteArray(), Base64.NO_WRAP)

    const val BASE_URL = "http://192.168.0.223/mobile/public/"
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .addHeader(
                    "Authorization",
                    AUTH
                )
                .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: RoleApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(RoleApi::class.java)
    }
}

