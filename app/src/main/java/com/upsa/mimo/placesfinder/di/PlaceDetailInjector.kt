package com.upsa.mimo.placesfinder.di

import com.upsa.mimo.placesfinder.ui.placedetail.IPlaceDetailView
import com.upsa.mimo.placesfinder.ui.placedetail.PlaceDetailPresenter

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class PlaceDetailInjector(private val injector: Injector) {
    fun providesPlaceDetailPresenter(view: IPlaceDetailView) =
        PlaceDetailPresenter(
            view,
            injector.repositoryInjector.providesRepository()
        )
}