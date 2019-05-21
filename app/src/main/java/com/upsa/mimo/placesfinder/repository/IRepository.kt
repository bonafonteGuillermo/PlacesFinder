package com.upsa.mimo.placesfinder.repository

import android.location.Location
import com.upsa.mimo.placesfinder.model.Place
import io.reactivex.Observable

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
interface IRepository {
    fun getNearByPlaces(location: Location) : Observable<List<Place>>
}