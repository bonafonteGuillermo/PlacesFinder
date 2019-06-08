package com.upsa.mimo.placesfinder.di

import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.ui.places.IPlacesView
import com.upsa.mimo.placesfinder.ui.places.PlacesPresenter

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class PlacesInjector(private val injector: Injector) {
    fun providesPlacesPresenter(view: IPlacesView) =
        PlacesPresenter(
            view,
            injector.repositoryInjector.providesRepository(),
            SchedulersInjector.providesSchedulers(),
            LocationInjector.providesLocationProvider(view as Fragment)
        )
}