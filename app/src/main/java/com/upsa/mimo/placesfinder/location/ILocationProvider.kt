package com.upsa.mimo.placesfinder.location

import android.location.Location
import io.reactivex.Observable

interface ILocationProvider {
    fun getLocation() : Observable<Location>
    fun permissionsGranted()
}