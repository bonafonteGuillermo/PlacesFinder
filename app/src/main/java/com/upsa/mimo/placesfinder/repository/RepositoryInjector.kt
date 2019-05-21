package com.upsa.mimo.placesfinder.repository

import com.upsa.mimo.placesfinder.app.Injector

class RepositoryInjector(private val injector: Injector) {
    fun providesRepository() = Repository(
        injector.apiInjector.providesApi(),
        injector.databaseInjector.providesAppDatabase(),
        injector.preferencesInjector.providesSharedPreferences())
}