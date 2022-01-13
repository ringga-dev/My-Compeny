package com.ringga.myetowa.data.api

import com.ringga.myetowa.data.model.*
import okhttp3.Credentials
import okhttp3.Interceptor
import retrofit2.Call
import retrofit2.http.*

interface RoleApi {
    /** fungsi post*/
    @FormUrlEncoded
    @POST("MobileApi/login")
    fun loginUser(
        @Field("username") email: String,
        @Field("password") password: String
    ): Call<BaseAuthRespon<UserRespon>>

    @FormUrlEncoded
    @POST("MobileApi/RegiterApi")
    fun registerUser(
        @Field("badge") badge: String,
        @Field("fullname") fullname: String,
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("devisi") devisi: String,
        @Field("pangkat") pangkat: String,
        @Field("alamat") alamat: String,
        @Field("stts") stts: String,
        @Field("no_phone") no_phone: String,
        @Field("password") password: String,
    ): Call<BaseRegisterRespon>


    /** fungsi get start*/
    @GET("MobileApi/get_order")
    fun getOrder(
        @Header("Authorization") token: String,
        @Query("badge") badge: String,
        @Query("stts") stts: String,
        ): Call<BaseRespon<OrderUser>>


}


