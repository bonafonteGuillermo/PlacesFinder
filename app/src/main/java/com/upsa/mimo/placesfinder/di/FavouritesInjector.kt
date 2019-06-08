package com.upsa.mimo.placesfinder.di

import com.upsa.mimo.placesfinder.ui.favourites.FavouritesPresenter
import com.upsa.mimo.placesfinder.ui.favourites.IFavouritesView

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class FavouritesInjector(private val injector: Injector) {
    fun providesFavouritesPresenter(view: IFavouritesView) =
        FavouritesPresenter(
            view,
            injector.repositoryInjector.providesRepository(),
            SchedulersInjector.providesSchedulers()
        )
}