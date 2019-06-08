package com.upsa.mimo.placesfinder.data.database

import androidx.room.*
import com.upsa.mimo.placesfinder.model.Place
import io.reactivex.Completable

@Dao
interface PlacesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlace(vararg place : Place)

    @Delete
    fun deletePlace(vararg place : Place): Int

    @Query("SELECT * FROM place WHERE place_id LIKE :placeId")
    fun getPlace(vararg placeId : String) : Place

    @Query("SELECT * FROM place")
    fun getPlaces() : List<Place>

}