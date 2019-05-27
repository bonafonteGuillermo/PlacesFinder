package com.upsa.mimo.placesfinder.di

import android.content.Context
import com.upsa.mimo.placesfinder.data.preferences.SharedPrefs

object SharedPrefsInjector {
    fun providesSharedPreferences(context: Context) = SharedPrefs(context)
}