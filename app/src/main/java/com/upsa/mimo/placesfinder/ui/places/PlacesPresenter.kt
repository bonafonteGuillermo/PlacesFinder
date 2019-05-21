package com.upsa.mimo.placesfinder.ui.places

import android.location.LocationProvider
import com.upsa.mimo.placesfinder.location.ILocationProvider
import com.upsa.mimo.placesfinder.repository.IRepository
import com.upsa.mimo.placesfinder.rx.AppSchedulers

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class PlacesPresenter(
    override var view: IPlacesView,
    private val repository: IRepository,
    private val schedulers: AppSchedulers,
    private val locationProvider: ILocationProvider
) : IPlacesPresenter {

}