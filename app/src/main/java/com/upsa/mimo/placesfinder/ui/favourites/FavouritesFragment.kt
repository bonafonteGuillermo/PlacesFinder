package com.upsa.mimo.placesfinder.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.Preconditions.checkNotNull
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.ui.favourites.adapter.FragmentViewPagerAdapter
import com.upsa.mimo.placesfinder.ui.favourites.utils.CardTransformer
import kotlinx.android.synthetic.main.fragment_favourites.*

class FavouritesFragment : Fragment(), IFavouritesView {


    private lateinit var presenter: IFavouritesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.favouritesInjector.providesFavouritesPresenter(this)
        presenter.getFavouritePlaces()
    }

    override fun bindFavouritesPlacesData(favouritesPlaces: List<Place>) {
        val viewPagerAdapter = FragmentViewPagerAdapter(favouritesPlaces, checkNotNull(fragmentManager))
        favourites__view_pager.adapter = viewPagerAdapter
        favourites__view_pager.setPageTransformer(true, CardTransformer(favourites__view_pager, viewPagerAdapter))
        favourites__view_pager.pageMargin = 60
    }
}
