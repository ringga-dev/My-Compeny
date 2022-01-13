package com.ringga.myetowa.ui.menu_home

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ringga.myetowa.data.api.ClientApi
import com.ringga.myetowa.data.api.ClientAuthApi
import com.ringga.myetowa.data.database.PreferencesToken.Companion.getToken
import com.ringga.myetowa.data.database.SharedPrefManager
import com.ringga.myetowa.data.model.BaseAuthRespon
import com.ringga.myetowa.data.model.BaseRespon
import com.ringga.myetowa.data.model.OrderUser
import com.ringga.myetowa.data.model.UserRespon
import com.ringga.myetowa.data.utils.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserHomeViewModel : ViewModel() {
    private var state: SingleLiveEvent<UserHomeState> = SingleLiveEvent()
    private var api = ClientAuthApi.instance
    fun getOrderUser(ctx: Context, stts: String) {
        val user = SharedPrefManager.getInstance(ctx).user
        api.getOrder("Bearer ${getToken(ctx)!!}", user.badge, stts)
            .enqueue(object : Callback<BaseRespon<OrderUser>> {
                override fun onResponse(
                    call: Call<BaseRespon<OrderUser>>,
                    response: Response<BaseRespon<OrderUser>>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()!!.stts) {
                            state.value = UserHomeState.userOrder(response.body()!!)
                            state.value = UserHomeState.Error(response.body()!!.msg.toString())
                        } else {
                            state.value = UserHomeState.Error(response.body()!!.msg.toString())
                        }

                    } else {
                        state.value = UserHomeState.Error(response.body()!!.msg.toString())
                    }
                }

                override fun onFailure(call: Call<BaseRespon<OrderUser>>, t: Throwable) {
                    state.value = UserHomeState.Error(t.message!!)
                }

            })
    }

    fun getUser(context: Context) {
        state.value = UserHomeState.userData(SharedPrefManager.getInstance(context).user)
    }


    fun getState() = state

}

sealed class UserHomeState {
    data class Error(var err: String) : UserHomeState()
    data class ShoewToals(var message: String) : UserHomeState()
    data class userOrder(var data: BaseRespon<OrderUser>) : UserHomeState()
    data class userData(var data: UserRespon) : UserHomeState()
    data class IsLoding(var state: Boolean = false) : UserHomeState()
    data class Failed(var message: String) : UserHomeState()
    object Reset : UserHomeState()
}