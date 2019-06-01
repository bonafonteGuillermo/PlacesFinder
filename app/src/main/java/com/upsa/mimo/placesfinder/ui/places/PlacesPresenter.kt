package com.upsa.mimo.placesfinder.ui.places

import android.location.Location
import android.util.Log
import com.upsa.mimo.placesfinder.location.ILocationProvider
import com.upsa.mimo.placesfinder.data.repository.IRepository
import com.upsa.mimo.placesfinder.rx.AppSchedulers
import com.upsa.mimo.placesfinder.utils.getLocationQueryParam
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class PlacesPresenter(
    override var view: IPlacesView?,
    private val repository: IRepository,
    private val schedulers: AppSchedulers,
    private val locationProvider: ILocationProvider
) : IPlacesPresenter {

    init {
        view?.showLoading()
        requestLocation()
    }

    override fun requestLocation() {
        val observable = locationProvider.getLocation()
            .subscribeOn(schedulers.internet())
            .observeOn(schedulers.androidThread())
            .timeout(7, TimeUnit.SECONDS)
            .subscribe(
                { location -> getNearByPlaces(location) },
                { view?.showErrorDialog() }
            )
    }

    override fun permissionsGranted() {
        locationProvider.permissionsGranted()
    }

    private fun getNearByPlaces(location: Location) {
        val observable = repository.getNearByPlaces(location)
            .subscribeOn(schedulers.internet())
            .observeOn(schedulers.androidThread())
            .subscribe(
                {
                    view?.hideLoading()
                    it.forEach { place -> Log.d("->", place.toString()) }
                },
                {
                    view?.hideLoading()
                    view?.showErrorDialog()
                }
            )
    }

    override fun onDestroy() {
        view = null
    }
}