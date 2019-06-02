package com.upsa.mimo.placesfinder.ui.places

import android.location.Location
import android.util.Log
import com.upsa.mimo.placesfinder.location.ILocationProvider
import com.upsa.mimo.placesfinder.data.repository.IRepository
import com.upsa.mimo.placesfinder.rx.AppSchedulers
import com.upsa.mimo.placesfinder.utils.getLocationQueryParam
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import io.reactivex.disposables.CompositeDisposable



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

    private var disposables: CompositeDisposable = CompositeDisposable()

    init {
        requestLocation()
    }

    override fun permissionsGranted() {
        locationProvider.permissionsGranted()
    }

    override fun onDestroy() {
        view = null
    }

    override fun requestLocation() {
        val observable = locationProvider.getLocation()
            .subscribeOn(schedulers.internet())
            .observeOn(schedulers.androidThread())
            .timeout(10, TimeUnit.SECONDS)
            .doOnSubscribe {
                view?.showLoading()
                disposables.add(it)
            }
            .subscribe(
                { location -> getNearByPlaces(location) },
                { view?.showErrorDialog() }
            )
    }

    private fun getNearByPlaces(location: Location) {
        val observable = repository.getNearByPlaces(location)
            .subscribeOn(schedulers.internet())
            .observeOn(schedulers.androidThread())
            .doOnSubscribe { disposables.add(it) }
            .timeout(10, TimeUnit.SECONDS)
            .doFinally {
                disposables.clear()
                view?.hideLoading()
            }
            .subscribe(
                { view?.bindPlacesData(it)},
                { view?.showErrorDialog() }
            )
    }
}