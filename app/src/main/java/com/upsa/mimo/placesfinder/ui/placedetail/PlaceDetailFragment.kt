package com.upsa.mimo.placesfinder.ui.placedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector
import kotlinx.android.synthetic.main.fragment_place_detail.*

class PlaceDetailFragment : Fragment(), IPlaceDetailView {

    private lateinit var presenter: IPlaceDetailPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_place_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.placeDetailInjector.providesPlaceDetailPresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val place = PlaceDetailFragmentArgs.fromBundle(checkNotNull(arguments)).argumentPlace
        textView.text = place.toString()

        btn_add_to_favourite.setOnClickListener { presenter.addToFavourite(checkNotNull(place)) }
    }
}