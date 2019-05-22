package com.upsa.mimo.placesfinder.ui.places

import android.location.Location
import android.util.Log
import com.upsa.mimo.placesfinder.location.ILocationProvider
import com.upsa.mimo.placesfinder.repository.IRepository
import com.upsa.mimo.placesfinder.rx.AppSchedulers
import com.upsa.mimo.placesfinder.utils.getLocationQueryParam
import io.reactivex.disposables.Disposable

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

    init {
        requestLocation()
    }

    private fun requestLocation() {
        val observable = locationProvider.getLocation()
            .subscribeOn(schedulers.internet())
            .observeOn(schedulers.androidThread())
            .subscribe(
                { location -> getNearByPlaces(location) },
                { Log.d("->", it.toString()) }
            )
    }

    override fun permissionsGranted() {
        locationProvider.permissionsGranted()
    }

    private fun getNearByPlaces(location: Location) : Disposable {
        return repository.getNearByPlaces(location)
            .subscribeOn(schedulers.internet())
            .observeOn(schedulers.androidThread())
            .subscribe(
                { it.forEach { place -> Log.d("->", place.toString()) } },
                { Log.d("->", it.toString()) }
            )
    }
}