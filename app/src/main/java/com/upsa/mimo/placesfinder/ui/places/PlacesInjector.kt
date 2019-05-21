package com.upsa.mimo.placesfinder.ui.places

import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.app.Injector
/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class PlacesInjector(private val injector: Injector) {
    fun getInstancePresenter(view: IPlacesView) =
        PlacesPresenter(
            view,
            injector.repositoryInjector.getInstanceRepository(),
            injector.rxInjector.getInstanceRx(),
            injector.locationInjector.getInstanceLocationProvider(view as Fragment)
        )
}