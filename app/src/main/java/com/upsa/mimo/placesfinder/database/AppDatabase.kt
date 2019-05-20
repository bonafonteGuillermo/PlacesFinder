package com.upsa.mimo.placesfinder.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.upsa.mimo.placesfinder.model.Place

@Database(entities = [(Place::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun placesDao() : PlacesDao
}