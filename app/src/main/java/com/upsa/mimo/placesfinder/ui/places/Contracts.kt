package com.upsa.mimo.placesfinder.ui.places

import com.upsa.mimo.placesfinder.app.BasePresenter
import com.upsa.mimo.placesfinder.app.BaseView


/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
interface IPlacesPresenter : BasePresenter<IPlacesView> {
    fun permissionsGranted()
    fun onDestroy()
}

interface IPlacesView : BaseView