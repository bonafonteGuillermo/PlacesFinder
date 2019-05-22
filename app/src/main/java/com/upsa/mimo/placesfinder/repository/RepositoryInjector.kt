package com.upsa.mimo.placesfinder.repository

import android.content.Context
import com.upsa.mimo.placesfinder.app.Injector

class RepositoryInjector(private val injector: Injector, private val context: Context) {
    fun providesRepository() = Repository(
        injector.apiInjector.providesApi(
            injector.networkInjector.provideHttpClient(
                injector.networkInjector.provideLoggingInterceptor(),
                injector.networkInjector.provideCache(injector.networkInjector.provideCacheFile(context))
            ),
            injector.networkInjector.provideGsonClient(),
            injector.networkInjector.provideRxAdapter()
        ),
        injector.databaseInjector.providesAppDatabase(),
        injector.preferencesInjector.providesSharedPreferences())
}