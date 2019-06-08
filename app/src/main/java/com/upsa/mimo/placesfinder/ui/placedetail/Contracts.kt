package com.upsa.mimo.placesfinder.ui.placedetail

import com.upsa.mimo.placesfinder.app.BasePresenter
import com.upsa.mimo.placesfinder.app.BaseView
import com.upsa.mimo.placesfinder.model.Place

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
interface IPlaceDetailPresenter : BasePresenter<IPlaceDetailView> {
    fun addToFavourite(place : Place)
}

interface IPlaceDetailView : BaseView