package com.upsa.mimo.placesfinder.ui.favourites

import com.upsa.mimo.placesfinder.app.BasePresenter
import com.upsa.mimo.placesfinder.app.BaseView
import com.upsa.mimo.placesfinder.model.Place

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
interface IFavouritesPresenter : BasePresenter<IFavouritesView> {
    fun getFavouritePlaces()
}

interface IFavouritesView : BaseView {
    fun bindFavouritesPlacesData(favouritesPlaces: List<Place>)
}