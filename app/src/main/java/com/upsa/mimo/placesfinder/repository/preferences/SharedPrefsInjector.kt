package com.upsa.mimo.placesfinder.repository.preferences

import android.content.Context

object SharedPrefsInjector {
    fun providesSharedPreferences(context: Context) = SharedPrefs(context)
}