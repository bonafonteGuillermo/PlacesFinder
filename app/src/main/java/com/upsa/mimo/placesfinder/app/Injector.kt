package com.upsa.mimo.placesfinder.app

import android.content.Context
import com.upsa.mimo.placesfinder.favourites.FavouritesInjector
import com.upsa.mimo.placesfinder.placedetail.PlaceDetailInjector
import com.upsa.mimo.placesfinder.places.PlacesInjector
import com.upsa.mimo.placesfinder.repository.RepositoryInjector
import com.upsa.mimo.placesfinder.repository.api.ApiInjector
import com.upsa.mimo.placesfinder.repository.preferences.SharedPrefsInjector
import com.upsa.mimo.placesfinder.rx.RxInjector

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class Injector(private val context: Context) {
    val rxInjector by lazy { RxInjector() }
    val apiInjector by lazy { ApiInjector() }
    val placesInjector by lazy { PlacesInjector(this) }
    val preferencesInjector by lazy { SharedPrefsInjector(context) }
    val repositoryInjector by lazy { RepositoryInjector(this) }
    val favouritesInjector by lazy { FavouritesInjector(this) }
    val placeDetailInjector by lazy { PlaceDetailInjector(this) }
}