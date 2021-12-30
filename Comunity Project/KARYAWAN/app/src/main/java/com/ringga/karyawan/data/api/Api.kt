package com.ringga.karyawan.data.api




import com.ringga.karyawan.data.response.ResponCuaca
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    //cuacas
    @FormUrlEncoded
    @POST("dataterbuka/get_wilayah")
    fun wilayah(
        @Field("menu") menu: String,
        @Field("wilayah") wilayah: String
    ): Call<List<String>>


    @FormUrlEncoded
    @POST("dataterbuka/get_wilayah")
    fun cuaca(
        @Field("menu") menu: String,
        @Field("wilayah") wilayah: String
    ): Call<List<ResponCuaca>>

}


