package com.upsa.mimo.placesfinder.database

import android.content.Context
import androidx.room.Room

class AppDatabaseInjector(private val context: Context) {
    fun providesAppDatabase(): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my-app-db"
        ).build()
}