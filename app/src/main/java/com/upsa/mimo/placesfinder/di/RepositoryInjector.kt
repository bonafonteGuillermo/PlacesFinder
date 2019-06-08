package com.upsa.mimo.placesfinder.di

import android.content.Context
import com.upsa.mimo.placesfinder.data.repository.Repository

class RepositoryInjector(private val injector: Injector, private val context: Context) {
    fun providesRepository() = Repository(
        api = ApiClientInjector.providesApiClient(
            NetworkInjector.provideHttpClient(
                NetworkInjector.provideLoggingInterceptor(),
                NetworkInjector.provideCache(
                    NetworkInjector.provideCacheFile(
                        context
                    )
                )
            ),
            NetworkInjector.provideGsonClient(),
            NetworkInjector.provideRxAdapter()
        ),
        localStorage = AppDatabaseInjector.providesAppDatabase(context),
        prefs = injector.preferencesInjector.providesSharedPreferences(context),
        schedulers = injector.schedulersInjector.providesSchedulers()
    )
}