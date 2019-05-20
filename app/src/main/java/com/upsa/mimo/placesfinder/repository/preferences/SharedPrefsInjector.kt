package com.upsa.mimo.placesfinder.repository.preferences

import android.content.Context

class SharedPrefsInjector(private val context : Context) {
    fun providesSharedPreferences() = SharedPrefs(context)
}