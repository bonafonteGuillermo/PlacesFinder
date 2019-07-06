package com.upsa.mimo.placesfinder.ui.placedetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.utils.setPlaceRatingValue
import com.upsa.mimo.placesfinder.utils.setStaticMapImage
import com.upsa.mimo.placesfinder.utils.setTotalReviews
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
        with(btn_add_to_favourite) {
            background = safeContext.getDrawable(R.drawable.place_details__like_selected)
            tag = "SELECTED"
        }
    }

    override fun setPlaceNotAddedIcon() {
        with(btn_add_to_favourite) {
            background = safeContext.getDrawable(R.drawable.place_details__like_unselected)
            tag = "UNSELECTED"
        }
    }

    private fun addFavouriteButtonClicked() {
        if (btn_add_to_favourite.tag == "UNSELECTED") {
            presenter.addPlaceToFavourite(checkNotNull(place))
        } else {
            presenter.removePlaceFromFavourite(checkNotNull(place))
        }
    }

    fun bindPlaceData(place: Place?) {
        place?.let { place ->
            tv_detail_place_name.text = place.name
            tv_detail_place_vicinity.text = place.vicinity
            place_details__rating.setPlaceRatingValue(checkNotNull(place.rating))
            place_details__total_reviews.setTotalReviews(place.userRatingTotal.toString())
            image_map_view.setStaticMapImage(place)
        }
    }
}
