package com.upsa.mimo.placesfinder.ui.favourites

import com.upsa.mimo.placesfinder.app.Injector

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class FavouritesInjector(private val injector: Injector) {
    fun getInstancePresenter(view: IFavouritesView) =
        FavouritesPresenter(
            view,
            injector.repositoryInjector.getInstanceRepository(),
            injector.rxInjector.getInstanceRx()
        )
}