package com.upsa.mimo.placesfinder.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector

class PlacesFragment : Fragment(), IPlacesView {

    private lateinit var presenter: IPlacesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_places, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.placesInjector.getInstancePresenter(this)
    }
}