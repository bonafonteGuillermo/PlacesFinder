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
    var disposables : CompositeDisposable = CompositeDisposable()

    override fun addToFavourite(place : Place) {
        disposables += repository.addPlaceToLocalStorage(place).subscribe()
    }


}