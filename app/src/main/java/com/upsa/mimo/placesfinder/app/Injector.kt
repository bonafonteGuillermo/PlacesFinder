package com.upsa.mimo.placesfinder.app

import android.content.Context
import com.upsa.mimo.placesfinder.placedetail.PlaceDetailInjector
import com.upsa.mimo.placesfinder.places.PlacesInjector
import com.upsa.mimo.placesfinder.repository.Repository
import com.upsa.mimo.placesfinder.repository.SharedPrefs

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class Injector(private val context: Context) {

    private val prefs by lazy { SharedPrefs(context) }

    val repository by lazy { Repository(prefs) }

    val placesInjector by lazy { PlacesInjector(this) }
    val placeDetailInjector by lazy { PlaceDetailInjector(this) }

}