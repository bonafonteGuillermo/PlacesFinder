package com.upsa.mimo.placesfinder.utils

import android.location.Location
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

fun Location.getLocationQueryParam() : String{
    val sb = StringBuilder()
    sb.append(this.latitude).append(",").append(this.longitude)
    return sb.toString()
}