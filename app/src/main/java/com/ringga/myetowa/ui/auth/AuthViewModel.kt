package com.ringga.myetowa.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ringga.myetowa.data.api.ClientAuthApi
import com.ringga.myetowa.data.model.BaseAuthRespon
import com.ringga.myetowa.data.model.BaseRegisterRespon
import com.ringga.myetowa.data.model.UserRespon
import com.ringga.myetowa.data.utils.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Field

class AuthViewModel : ViewModel() {
    private var state: SingleLiveEvent<UserState> = SingleLiveEvent()
    private var api = ClientAuthApi.instance
    private var user = MutableLiveData<BaseAuthRespon<UserRespon>>()

    fun login(email: String, password: String) {
        state.value = UserState.IsLoding(true)
        api.loginUser(email, password).enqueue(object : Callback<BaseAuthRespon<UserRespon>> {
            override fun onResponse(
                call: Call<BaseAuthRespon<UserRespon>>,
                response: Response<BaseAuthRespon<UserRespon>>
            ) {
                if (response.isSuccessful) {
                    val body = response.body() as BaseAuthRespon<UserRespon>
                    if (body.stts == true) {
                        state.value = UserState.SuccessLogin(body)
                    } else {
                        state.value = UserState.Failed(body.msg)
                    }
                } else {
                    state.value = UserState.Failed(response.body()!!.msg)
                }
                state.value = UserState.IsLoding(false)
            }

            override fun onFailure(call: Call<BaseAuthRespon<UserRespon>>, t: Throwable) {
                state.value = UserState.Error(t.message!!)
                state.value = UserState.IsLoding(false)
            }

        })
    }

    fun register(badge:String,fullname:String,username:String,email: String,devisi:String,pangkat:String,alamat:String,stts:String,no_phone:String,password: String) {
        api.registerUser(badge, fullname, username, email,devisi, pangkat, alamat, stts ,no_phone,password).enqueue(object : Callback<BaseRegisterRespon> {
            override fun onResponse(
                call: Call<BaseRegisterRespon>,
                response: Response<BaseRegisterRespon>
            ) {
                if (response.isSuccessful) {
                    val body = response.body() as BaseRegisterRespon
                    state.value = UserState.SuccessRegister(body)
                } else {
                    state.value = UserState.Failed("terjadi kesalahan saat register")
                }

                state.value = UserState.IsLoding(false)
            }

            override fun onFailure(call: Call<BaseRegisterRespon>, t: Throwable) {
                state.value = UserState.Error(t.message!!)
            }

        })
    }


    fun getState() = state

    fun getUserData() = user
}

sealed class UserState {
    data class Error(var err: String) : UserState()
    data class ShoewToals(var message: String) : UserState()
    data class Validate(
        var name: String? = null,
        var email: String? = null,
        var password: String? = null
    ) : UserState()

    data class IsLoding(var state: Boolean = false) : UserState()
    data class SuccessLogin(var data: BaseAuthRespon<UserRespon>) : UserState()
    data class SuccessRegister(var data: BaseRegisterRespon) : UserState()
    data class Failed(var message: String) : UserState()
    object Reset : UserState()
}