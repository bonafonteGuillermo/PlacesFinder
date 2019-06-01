package com.upsa.mimo.placesfinder.utils

import android.content.Context
import android.location.Location
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar


fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

fun Location.getLocationQueryParam(): String {
    val sb = StringBuilder()
    sb.append(this.latitude).append(",").append(this.longitude)
    return sb.toString()
}

fun Context.showDialog(@StringRes title: Int, @StringRes message: Int, positiveListener: () -> Unit = {}) {

    //TODO pass positive button text as argument also

    AlertDialog.Builder(this)
        .setTitle(getString(title))
        .setMessage(message)
        .setNegativeButton(android.R.string.cancel) { dialog, _ -> dialog.dismiss() }
        .setPositiveButton("RETRY") { dialog, _ ->
            dialog.cancel()
            positiveListener()
        }
        .create()
        .show()
}