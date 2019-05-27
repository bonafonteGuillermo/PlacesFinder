package com.upsa.mimo.placesfinder.data.api

import com.upsa.mimo.placesfinder.model.PlacesResults
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("place/nearbysearch/json?")
    fun getPlaces(
        @Query("location") location: String?,
        @Query("radius") radius: String,
        @Query("type") type: String?,
        @Query("key") api_key: String
    ): Observable<PlacesResults>
}