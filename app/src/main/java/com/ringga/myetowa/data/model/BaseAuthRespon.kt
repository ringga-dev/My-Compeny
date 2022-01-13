package com.ringga.myetowa.data.model

import com.google.gson.annotations.SerializedName

data class BaseAuthRespon<T> (
    @SerializedName("stts") val stts : Boolean,
    @SerializedName("msg") val msg : String,
    @SerializedName("token") val token : String,
    @SerializedName("data") val data : T
)
data class BaseRegisterRespon(
    @SerializedName("stts") val stts : Boolean,
    @SerializedName("msg") val msg : String,
)

data class  UserRespon(
    @SerializedName("id") val id : Int,
    @SerializedName("badge") val badge : String,
    @SerializedName("fullname") val fullname : String,
    @SerializedName("username") val username : String,
    @SerializedName("email") val email : String,
    @SerializedName("image") val image : String,
    @SerializedName("no_phone") val no_phone : String,
    @SerializedName("devisi") val devisi : String,
    @SerializedName("pangkat") val pangkat : String,
    @SerializedName("alamat") val alamat : String,
    @SerializedName("stts") val stts : String,
)


data class BaseRespon<T>(
    @SerializedName("stts") val  stts:Boolean,
    @SerializedName("msg") val  msg:String,
    @SerializedName("data") val  data:List<T>,
)


data class OrderUser(
    @SerializedName("id") val  id:Boolean,
    @SerializedName("badge") val  badge:String,
    @SerializedName("name_produc") val  name_produc:String,
    @SerializedName("qty") val  qty:Int,
    @SerializedName("harga") val  harga:Int,
    @SerializedName("dec") val  dec:String,
    @SerializedName("fung") val  fung:String,
    @SerializedName("stts") val  stts:String,
    @SerializedName("reason") val  reason:String,
    @SerializedName("image") val  image:List<ImageOrder>,
)

data class ImageOrder(
    @SerializedName("id") val  id:Boolean,
    @SerializedName("id_member") val  id_member:Int,
    @SerializedName("image") val  image:String,
    @SerializedName("stts_image") val  stts_image:String,
    @SerializedName("url") val  url:String,
)
