package com.upsa.mimo.placesfinder.di

import android.content.Context

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class Injector(private val context: Context) {
    val rxInjector by lazy { RxInjector }
    val apiInjector by lazy { ApiClientInjector }
    val networkInjector by lazy { NetworkInjector }
    val locationInjector by lazy { LocationInjector }
    val placesInjector by lazy { PlacesInjector(this) }
    val databaseInjector by lazy { AppDatabaseInjector }
    val preferencesInjector by lazy { SharedPrefsInjector }
    val favouritesInjector by lazy { FavouritesInjector(this) }
    val placeDetailInjector by lazy { PlaceDetailInjector(this) }
    val repositoryInjector by lazy { RepositoryInjector(this, context) }
}