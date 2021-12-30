package com.ringga.karyawan.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ringga.karyawan.data.api.RetrofitClient
import com.ringga.karyawan.data.response.ResponCuaca
import com.ringga.karyawan.pekerjaan.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuacaViewModel : ViewModel() {
    private var state: SingleLiveEvent<UserState> = SingleLiveEvent()
    private var user = MutableLiveData<List<String>>()
    fun getWilayah(menu: String, wilayah: String) {
        state.value = UserState.IsLoding(true)
        RetrofitClient.instance.wilayah(menu, wilayah)
            .enqueue(object : Callback<List<String>> {
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {


                    if (response.isSuccessful) {
                        val body = response.body()
                        state.value = UserState.Success(body!!)
                    } else {
                        state.value = UserState.Failed("terjadi kesalahan saat login")
                    }
                    state.value = UserState.IsLoding(false)
                    state.value = UserState.IsLoding(false)
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    state.value = UserState.Error(t.message!!)
                }
            })
    }

    fun getCuaca(menu: String, wilayah: String) {
        state.value = UserState.IsLoding(true)
        RetrofitClient.instance.cuaca(menu, wilayah)
            .enqueue(object : Callback<List<ResponCuaca>> {
                override fun onResponse(
                    call: Call<List<ResponCuaca>>,
                    response: Response<List<ResponCuaca>>
                ) {


                    if (response.isSuccessful) {
                        val body = response.body()
                        state.value = UserState.Cuaca(body!!)
                    } else {
                        state.value = UserState.Failed("terjadi kesalahan saat login")
                    }
                    state.value = UserState.IsLoding(false)
                    state.value = UserState.IsLoding(false)
                }

                override fun onFailure(call: Call<List<ResponCuaca>>, t: Throwable) {
                    state.value = UserState.Error(t.message!!)
                }
            })
    }

    fun getState() = state

    fun getWilayahData() =user


}

sealed class UserState {
    data class Error(var err: String) : UserState()
    data class ShoewToals(var message: String) : UserState()
    data class IsLoding(var state: Boolean = false) : UserState()
    data class Success(var data: List<String>) : UserState()
    data class Cuaca(var data: List<ResponCuaca>) : UserState()
    data class Failed(var message: String) : UserState()
    object Reset : UserState()
}

