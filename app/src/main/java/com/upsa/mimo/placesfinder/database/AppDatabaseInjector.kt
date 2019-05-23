package com.upsa.mimo.placesfinder.database

import android.content.Context
import androidx.room.Room

object AppDatabaseInjector {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    //TODO move to appdatabase
    fun providesAppDatabase(context: Context): AppDatabase =
        INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildAppDatabase(context).also { INSTANCE = it }
        }

    private fun buildAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my-app-db"
        ).build()


}