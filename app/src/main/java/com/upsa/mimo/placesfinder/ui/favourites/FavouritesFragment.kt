package com.upsa.mimo.placesfinder.ui.favourites

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector


class FavouritesFragment : Fragment(), IFavouritesView {

    private lateinit var presenter: IFavouritesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.favouritesInjector.providesFavouritesPresenter(this)
    }
}