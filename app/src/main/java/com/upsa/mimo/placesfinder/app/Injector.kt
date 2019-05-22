package com.upsa.mimo.placesfinder.app

import android.content.Context
import com.upsa.mimo.placesfinder.database.AppDatabaseInjector
import com.upsa.mimo.placesfinder.location.LocationInjector
import com.upsa.mimo.placesfinder.ui.favourites.FavouritesInjector
import com.upsa.mimo.placesfinder.ui.placedetail.PlaceDetailInjector
import com.upsa.mimo.placesfinder.ui.places.PlacesInjector
import com.upsa.mimo.placesfinder.repository.RepositoryInjector
import com.upsa.mimo.placesfinder.repository.api.ApiInjector
import com.upsa.mimo.placesfinder.repository.api.network.NetworkInjector
import com.upsa.mimo.placesfinder.repository.preferences.SharedPrefsInjector
import com.upsa.mimo.placesfinder.rx.RxInjector

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class Injector(private val context: Context) {
    val rxInjector by lazy { RxInjector() }
    val apiInjector by lazy { ApiInjector() }
    val networkInjector by lazy { NetworkInjector() }
    val locationInjector by lazy { LocationInjector() }
    val placesInjector by lazy { PlacesInjector(this) }
    val databaseInjector by lazy { AppDatabaseInjector(context) }
    val preferencesInjector by lazy { SharedPrefsInjector(context) }
    val favouritesInjector by lazy { FavouritesInjector(this) }
    val placeDetailInjector by lazy { PlaceDetailInjector(this) }
    val repositoryInjector by lazy { RepositoryInjector(this, context) }
}