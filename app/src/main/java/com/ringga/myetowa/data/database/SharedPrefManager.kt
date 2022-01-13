package com.ringga.myetowa.data.database
/*=================== T H A N K   Y O U ===================*/
/*============= TELAH MENGUNAKAN CODE SAYA ================*/
            /* https://github.com/ringga-dev */
/*=========================================================*/
/*     R I N G G A   S E P T I A  P R I B A D I            */
/*=========================================================*/
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.ringga.myetowa.data.model.UserRespon


class SharedPrefManager private constructor(mCtx: Context) {
    private val mCtx: Context
    fun saveUser(user: UserRespon) {
        val sharedPreferences: SharedPreferences = mCtx.getSharedPreferences(
            SHARED_PREF_NAME,
            Context.MODE_PRIVATE
        )


        val editor = sharedPreferences.edit()
        editor.putInt("id", user.id)
        editor.putString("badge", user.badge)
        editor.putString("fullname", user.fullname)
        editor.putString("username", user.username)
        editor.putString("email", user.email)
        editor.putString("image", user.image)
        editor.putString("no_phone", user.no_phone)
        editor.putString("devisi", user.devisi)
        editor.putString("pangkat", user.pangkat)
        editor.putString("alamat", user.alamat)
        editor.putString("stts", user.stts)
        editor.apply()
    }

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences: SharedPreferences = mCtx.getSharedPreferences(
                SHARED_PREF_NAME,
                Context.MODE_PRIVATE
            )
            return sharedPreferences.getInt("id", -1) != -1
        }

    val user: UserRespon
        get() {
            val sharedPreferences: SharedPreferences = mCtx.getSharedPreferences(
                SHARED_PREF_NAME,
                Context.MODE_PRIVATE
            )
            return UserRespon(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("badge", null)!!,
                sharedPreferences.getString("fullname", null)!!,
                sharedPreferences.getString("username", null)!!,
                sharedPreferences.getString("email", null)!!,
                sharedPreferences.getString("image", null)!!,
                sharedPreferences.getString("no_phone", null)!!,
                sharedPreferences.getString("devisi", null)!!,
                sharedPreferences.getString("pangkat", null)!!,
                sharedPreferences.getString("alamat", null)!!,
                sharedPreferences.getString("stts", null)!!
            )
        }

    fun clear() {
        val sharedPreferences: SharedPreferences = mCtx.getSharedPreferences(
            SHARED_PREF_NAME,
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private const val SHARED_PREF_NAME = "my_shared_preff"
        @SuppressLint("StaticFieldLeak")
        private var mInstance: SharedPrefManager? = null
        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }

    init {
        this.mCtx = mCtx
    }
}