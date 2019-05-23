package com.upsa.mimo.placesfinder.repository

import android.content.Context
import com.upsa.mimo.placesfinder.app.Injector

class RepositoryInjector(private val injector: Injector, private val context: Context) {
    fun providesRepository() = Repository(
        api = injector.apiInjector.providesApiClient(
            injector.networkInjector.provideHttpClient(
                injector.networkInjector.provideLoggingInterceptor(),
                injector.networkInjector.provideCache(injector.networkInjector.provideCacheFile(context))
            ),
            injector.networkInjector.provideGsonClient(),
            injector.networkInjector.provideRxAdapter()
        ),
        localStorage = injector.databaseInjector.providesAppDatabase(context),
        prefs = injector.preferencesInjector.providesSharedPreferences(context)
    )
}