package com.upsa.mimo.placesfinder.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.model.Place
import kotlinx.android.synthetic.main.favourite_item.view.*

class FavouriteSlideFragment : Fragment() {

    private var place: Place? = null

    companion object {
        private const val PLACE = "place"

        fun newInstance(place: Place) =
            FavouriteSlideFragment().apply { arguments = bundleOf(FavouriteSlideFragment.PLACE to place) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        arguments?.let { place = it.getParcelable(PLACE) }
        return inflater.inflate(R.layout.favourite_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.tv_favourite_place_name.text = place?.name
    }
}