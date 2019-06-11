package com.upsa.mimo.placesfinder.ui.places

import android.location.Location
import com.upsa.mimo.placesfinder.location.ILocationProvider
import com.upsa.mimo.placesfinder.data.repository.IRepository
import com.upsa.mimo.placesfinder.rx.AppSchedulers
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

    override fun permissionsGranted() {
        locationProvider.permissionsGranted()
    }

    override fun onDestroy() {
        view = null
    }

    override fun requestLocation() {
        val observable = locationProvider.getLocation()
            .subscribeOn(schedulers.internet())
            .observeOn(schedulers.uiThread())
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
            .observeOn(schedulers.uiThread())
            .doOnSubscribe { disposables.add(it) }
            .doFinally {
                disposables.clear()
                view?.hideLoading()
                view?.hideSwipeToRefresh()
            }
            .subscribe(
                { view?.bindPlacesData(it)},
                { view?.showErrorDialog() }
            )
    }
}