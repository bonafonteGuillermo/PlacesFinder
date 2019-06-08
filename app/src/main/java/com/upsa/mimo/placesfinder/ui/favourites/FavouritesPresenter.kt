package com.upsa.mimo.placesfinder.ui.favourites

import com.upsa.mimo.placesfinder.data.repository.IRepository
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.rx.AppSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class FavouritesPresenter(
    override var view: IFavouritesView?,
    private val repository: IRepository,
    private val schedulers: AppSchedulers
) : IFavouritesPresenter {

    private var disposable: CompositeDisposable = CompositeDisposable()

    override fun getFavouritePlaces() {
        disposable += repository.getAllPlacesFromLocalStorage().subscribe(
            {
                view?.bindFavouritesPlacesData(it)
            },
            {

            })
    }


}