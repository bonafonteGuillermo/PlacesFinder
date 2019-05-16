package com.upsa.mimo.placesfinder.app

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
interface BasePresenter<V : BaseView> {
    val view: V
}