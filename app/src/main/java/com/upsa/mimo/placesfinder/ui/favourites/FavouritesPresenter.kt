package com.upsa.mimo.placesfinder.ui.favourites

import com.upsa.mimo.placesfinder.data.repository.IRepository
import com.upsa.mimo.placesfinder.rx.AppSchedulers
/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class FavouritesPresenter(
    override var view: IFavouritesView?,
    private val repository: IRepository,
    private val schedulers: AppSchedulers
) : IFavouritesPresenter {


}