package com.ringga.myetowa.data.utils

import android.content.Context
import android.content.res.Resources
import android.view.View
import com.ringga.myetowa.R
import com.ringga.myetowa.data.model.BaseRegisterRespon


fun View.ValidationUsername(email: String): BaseRegisterRespon {

    if (email.isEmpty()) {
        return BaseRegisterRespon(stts = false, resources.getString(R.string.username_validation_false))
    }

    return BaseRegisterRespon(true, "")
}

fun View.ValidationUsernameEmail(email: String): BaseRegisterRespon {

    if (email.isEmpty()) {
        return BaseRegisterRespon(stts = false, resources.getString(R.string.username_email_validation_false))
    }

    return BaseRegisterRespon(true, "")
}


fun View.ValidationEmail(email: String): BaseRegisterRespon {

    if (email.isEmpty()) {
        return BaseRegisterRespon(stts = false, resources.getString(R.string.email_validation_false))
    }
    if (!isVAlidEmail(email)) {
        return BaseRegisterRespon(false, resources.getString(R.string.email_validation_false2))
    }

    return BaseRegisterRespon(true, "")
}

fun View.ValidationPassword(password: String): BaseRegisterRespon {
    if (password.isEmpty()) {
        return BaseRegisterRespon(false, resources.getString(R.string.password_validation_false))
    }
    if (password.length < 6) {
        return BaseRegisterRespon(false, resources.getString(R.string.password_validation_false2))
    }
    return BaseRegisterRespon(true, "")
}

fun isVAlidEmail(email: String) =
    android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

fun View.ValidationBadge(badge:String):BaseRegisterRespon{
    if (badge.isEmpty()) {
        return BaseRegisterRespon(false, resources.getString(R.string.badge_validation_false))
    }
    return BaseRegisterRespon(true, "")
}

fun View.ValidationFullname(fullname:String):BaseRegisterRespon{
    if (fullname.isEmpty()) {
        return BaseRegisterRespon(false, resources.getString(R.string.fullname_validation_false))
    }
    return BaseRegisterRespon(true, "")
}

fun View.ValidationDevisi(devisi:String):BaseRegisterRespon{
    if (devisi.isEmpty()) {
        return BaseRegisterRespon(false, resources.getString(R.string.devisi_validation_false))
    }
    return BaseRegisterRespon(true, "")
}

fun View.ValidationPangkat(pangkat:String):BaseRegisterRespon{
    if (pangkat.isEmpty()) {
        return BaseRegisterRespon(false, resources.getString(R.string.pangkat_validation_false))
    }
    return BaseRegisterRespon(true, "")
}

fun View.ValidationAlamat(alamat:String):BaseRegisterRespon{
    if (alamat.isEmpty()) {
        return BaseRegisterRespon(false, resources.getString(R.string.alamat_validation_false))
    }
    return BaseRegisterRespon(true, "")
}

fun View.ValidationStts(stts:String):BaseRegisterRespon{
    if (stts.isEmpty()) {
        return BaseRegisterRespon(false, resources.getString(R.string.stts_validation_false))
    }
    return BaseRegisterRespon(true, "")
}

fun View.ValidationPhone(phone:String):BaseRegisterRespon{
    if (phone.isEmpty()) {
        return BaseRegisterRespon(false, resources.getString(R.string.phone_validation_false))
    }
    return BaseRegisterRespon(true, "")
}


