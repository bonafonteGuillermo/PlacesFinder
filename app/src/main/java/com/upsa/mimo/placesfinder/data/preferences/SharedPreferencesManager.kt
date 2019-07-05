package com.upsa.mimo.placesfinder.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.upsa.mimo.placesfinder.BuildConfig
import com.upsa.mimo.placesfinder.R

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class SharedPrefs(val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

    var filterType: String
        get() = checkNotNull(
            sharedPreferences.getString(
                FILTER_TYPE,
                context.getString(R.string.settings__filter_type_museum)
            )
        )
        set(value) = sharedPreferences.edit().putString(FILTER_TYPE, value).apply()

    var filterRadius: Int
        get() = checkNotNull(sharedPreferences.getInt(FILTER_RADIUS, 2500))
        set(value) = sharedPreferences.edit().putInt(FILTER_RADIUS, value).apply()

    fun detelePrefs() {
        sharedPreferences.edit().clear().apply()
    }
}

private const val FILTER_TYPE = "type"
private const val FILTER_RADIUS = "radius"
private const val PREFS_FILENAME = BuildConfig.APPLICATION_ID
