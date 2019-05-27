package com.upsa.mimo.placesfinder.di

import android.content.Context
import androidx.room.Room
import com.upsa.mimo.placesfinder.data.database.AppDatabase

object AppDatabaseInjector {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    //TODO move to appdatabase
    fun providesAppDatabase(context: Context): AppDatabase =
        INSTANCE ?: synchronized(this) {
            INSTANCE
                ?: buildAppDatabase(context).also { INSTANCE = it }
        }

    private fun buildAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my-app-db"
        ).build()


}