package com.upsa.mimo.placesfinder.placedetail

import com.upsa.mimo.placesfinder.app.Injector

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class PlaceDetailInjector(private val injector: Injector) {
    fun getInstancePresenter(view: IPlaceDetailView) = PlaceDetailPresenter(view)
}