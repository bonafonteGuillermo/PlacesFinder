package com.upsa.mimo.placesfinder.ui.places

import com.upsa.mimo.placesfinder.app.BasePresenter
import com.upsa.mimo.placesfinder.app.BaseView
import com.upsa.mimo.placesfinder.model.Place


/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
interface IPlacesPresenter : BasePresenter<IPlacesView> {
    fun requestLocation()
    fun permissionsGranted()
    fun onDestroy()
}

interface IPlacesView : BaseView {
    fun showLoading()
    fun hideLoading()
    fun showErrorDialog()
    fun bindPlacesData(places: List<Place>)
}