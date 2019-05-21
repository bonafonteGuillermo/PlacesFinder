package com.upsa.mimo.placesfinder.location

import android.location.Location
import io.reactivex.Observable

interface ILocationProvider {
    fun getMyLocation() : Observable<Location>
    fun permissionsGranted()
}