package com.upsa.mimo.placesfinder.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.utils.setPlaceRatingValue
import com.upsa.mimo.placesfinder.utils.setStaticMapImage
import com.upsa.mimo.placesfinder.utils.setTotalReviews
import kotlinx.android.synthetic.main.fragment_place_detail.*

class FavouriteSlideFragment : Fragment() {

    private var place: Place? = null

    companion object {
        private const val PLACE = "place"

        fun newInstance(place: Place) =
            FavouriteSlideFragment().apply { arguments = bundleOf(FavouriteSlideFragment.PLACE to place) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        arguments?.let { place = it.getParcelable(PLACE) }
        return inflater.inflate(R.layout.fragment_place_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindPlaceData(place)
    }

    private fun bindPlaceData(place: Place?) {
        btn_add_to_favourite.visibility = View.GONE
        place?.let { place ->
            tv_detail_place_name.text = place.name
            tv_detail_place_vicinity.text = place.vicinity
            place_details__rating.setPlaceRatingValue(checkNotNull(place.rating))
            place_details__total_reviews.setTotalReviews(place.userRatingTotal.toString())
            image_map_view.setStaticMapImage(place)
        }
    }
}
