package com.upsa.mimo.placesfinder.data.repository

import android.location.Location
import com.upsa.mimo.placesfinder.model.Place
import io.reactivex.Completable
import io.reactivex.Single

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
interface IRepository {
    fun getNearByPlaces(location: Location) : Single<List<Place>>
    fun addPlaceToLocalStorage(place: Place) : Completable
    fun getPlaceFromLocalStorage(placeId: String): Single<Place?>
    fun removePlaceFromLocalStorage(place: Place) : Single<Int>
    fun getAllPlacesFromLocalStorage(): Single<List<Place>>
    fun saveFilterTypeInSharedPrefs(type : String)
    fun saveFilterRadiusInSharedPrefs(radius : Int)
    fun getFilterTypeFromSharedPrefs() : String
    fun getFilterRadiusFromSharedPrefs() : Int
}