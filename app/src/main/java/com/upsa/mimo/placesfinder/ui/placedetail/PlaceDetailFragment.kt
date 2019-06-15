package com.upsa.mimo.placesfinder.ui.placedetail

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector
import com.upsa.mimo.placesfinder.model.Place
import kotlinx.android.synthetic.main.fragment_place_detail.*

class PlaceDetailFragment : Fragment(), IPlaceDetailView {

    private lateinit var presenter: IPlaceDetailPresenter
    private var place: Place? = null
    private lateinit var safeContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        safeContext = view.context

        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.placeDetailInjector.providesPlaceDetailPresenter(this)

        place = PlaceDetailFragmentArgs.fromBundle(checkNotNull(arguments)).argumentPlace
        place?.let {
            bindPlaceData(it)
            presenter.checkFavouritePlace(checkNotNull(it.placeId))
        }
        btn_add_to_favourite.setOnClickListener { addFavouriteButtonClicked() }
    }

    override fun setPlaceAlreadyAddedIcon() {
        btn_add_to_favourite.text = "REMOVE"
    }

    override fun setPlaceNotAddedIcon() {
        btn_add_to_favourite.text = "ADD"
    }

    private fun addFavouriteButtonClicked() {
        if (btn_add_to_favourite.text == "ADD") {
            presenter.addPlaceToFavourite(checkNotNull(place))
        } else {
            presenter.removePlaceFromFavourite(checkNotNull(place))
        }
    }

    private fun bindPlaceData(place: Place?) {
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