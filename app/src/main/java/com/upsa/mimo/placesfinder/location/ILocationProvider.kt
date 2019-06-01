package com.upsa.mimo.placesfinder.location

import android.location.Location
import io.reactivex.Single

interface ILocationProvider {
    fun getLocation() : Single<Location>
    fun permissionsGranted()
}