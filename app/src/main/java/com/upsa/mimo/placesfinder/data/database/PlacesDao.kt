package com.upsa.mimo.placesfinder.data.database

import androidx.room.*
import com.upsa.mimo.placesfinder.model.Place

@Dao
interface PlacesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlace(vararg place : Place)

    @Delete
    fun deletePlace(vararg place : Place): Int
}