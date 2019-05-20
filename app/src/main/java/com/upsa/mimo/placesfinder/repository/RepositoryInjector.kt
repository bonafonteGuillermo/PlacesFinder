package com.upsa.mimo.placesfinder.repository

import com.upsa.mimo.placesfinder.app.Injector

class RepositoryInjector(private val injector: Injector) {
    fun getInstanceRepository() = Repository(
        injector.apiInjector.providesApi(),
        injector.preferencesInjector.providesSharedPreferences())
}