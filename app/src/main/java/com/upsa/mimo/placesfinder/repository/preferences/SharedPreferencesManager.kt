package com.upsa.mimo.placesfinder.repository.preferences

import android.content.Context
import android.content.SharedPreferences
import com.upsa.mimo.placesfinder.BuildConfig

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class SharedPrefs(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

    var style: String
        get() = sharedPreferences.getString(STYLE, "")
        set(value) = sharedPreferences.edit().putString(STYLE, value).apply()

    fun detelePrefs(){
        sharedPreferences.edit().clear().apply()
    }
}

private const val STYLE = "style"
private const val PREFS_FILENAME = BuildConfig.APPLICATION_ID