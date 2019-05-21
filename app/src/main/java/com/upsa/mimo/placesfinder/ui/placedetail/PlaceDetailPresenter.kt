package com.upsa.mimo.placesfinder.ui.placedetail

import com.upsa.mimo.placesfinder.repository.IRepository

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class PlaceDetailPresenter(
    override var view: IPlaceDetailView,
    private val repository: IRepository
) : IPlaceDetailPresenter {
}