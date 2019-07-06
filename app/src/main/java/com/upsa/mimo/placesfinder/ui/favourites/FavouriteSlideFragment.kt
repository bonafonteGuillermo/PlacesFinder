package com.upsa.mimo.placesfinder.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.model.Place
import kotlinx.android.synthetic.main.favourite_item.view.*
import kotlinx.android.synthetic.main.fragment_place_detail.*
import kotlinx.android.synthetic.main.fragment_place_detail.view.*

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
        tv_detail_place_name.text = place?.name
        tv_detail_place_vicinity.text = place?.vicinity
        setRatingBar()
        setTotalReviews()
        Glide
            .with(this)
            .load("https://maps.googleapis.com/maps/api/staticmap?center=${place?.geometry?.location?.lat}%2c%20${place?.geometry?.location?.lng}&zoom=16&size=400x400&scale=2x400&markers=color:blue%7C${place?.geometry?.location?.lat},${place?.geometry?.location?.lng}&key=AIzaSyANHdY3Bxr-Oc6_FjXpZTskCXz65uV_gaE")
            .centerCrop()
            .into(image_map_view)
    }

    private fun setRatingBar() {
        place?.rating?.let {
            with(place_details__rating) {
                progress = it.toInt()
                setIsIndicator(true)
            }
        }
    }

    private fun setTotalReviews() {
        place?.userRatingTotal?.let {
            place_details__total_reviews.text = it.toString()
        }
    }
}