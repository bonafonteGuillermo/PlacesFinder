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
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.ui.favourites.adapter.FavouritesAdapter
import com.upsa.mimo.placesfinder.ui.places.adapter.PlacesAdapter
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.android.synthetic.main.fragment_places.*


class FavouritesFragment : Fragment(), IFavouritesView {


    private lateinit var presenter: IFavouritesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.favouritesInjector.providesFavouritesPresenter(this)
        presenter.getFavouritePlaces()
    }

    override fun bindFavouritesPlacesData(favouritesPlaces: List<Place>) {
        val favouritePlacesAdapter = FavouritesAdapter { navigateTo(it) }
        favouritePlacesAdapter.data = favouritesPlaces
        recycler_view_favourites_places.adapter = favouritePlacesAdapter
    }

    private fun navigateTo(place: Place) {

    }

}