package com.upsa.mimo.placesfinder.ui.placedetail

import com.upsa.mimo.placesfinder.data.repository.IRepository
import com.upsa.mimo.placesfinder.model.Place
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class PlaceDetailPresenter(
    override var view: IPlaceDetailView?,
    private val repository: IRepository
) : IPlaceDetailPresenter {

    //TODO clear disposables
    var disposables: CompositeDisposable = CompositeDisposable()

    override fun addPlaceToFavourite(place: Place) {
        disposables += repository.addPlaceToLocalStorage(place)
            .doAfterTerminate { view?.setPlaceAlreadyAddedIcon() }
            .subscribe()
    }

    override fun removePlaceFromFavourite(place: Place) {
        disposables += repository.removePlaceFromLocalStorage(place)
            .subscribe(
                {
                    if (it > 0) view?.setPlaceNotAddedIcon()
                }, {

                    /*TODO handle error*/
                })
    }

    override fun checkFavouritePlace(placeId: String) {
        disposables += repository.getPlaceFromLocalStorage(placeId)
            .subscribe({ place ->
                if (place != null) {
                    view?.setPlaceAlreadyAddedIcon()
                } else {
                    view?.setPlaceNotAddedIcon()
                }
            }, {
                /*TODO handle error*/
            })
    }

}
