package com.upsa.mimo.placesfinder.ui.favourites.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.ui.favourites.FavouriteSlideFragment

class FragmentViewPagerAdapter(private var places: List<Place>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return FavouriteSlideFragment.newInstance(places[position])
    }

    override fun getCount(): Int {
        return places.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return places[position].name
    }
}