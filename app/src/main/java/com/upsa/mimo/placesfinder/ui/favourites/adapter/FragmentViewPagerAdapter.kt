package com.upsa.mimo.placesfinder.ui.favourites.adapter

import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.ui.favourites.FavouriteSlideFragment
import java.util.*

class FragmentViewPagerAdapter(private var places: List<Place>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val mFragments = ArrayList<FavouriteSlideFragment>()

    override fun getItem(position: Int): Fragment {
        val favouriteSlideFragment = FavouriteSlideFragment.newInstance(places[position])
        addCardFragment(favouriteSlideFragment)
        return favouriteSlideFragment
    }

    override fun getCount(): Int {
        return places.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return places[position].name
    }

    fun getCardViewAt(position: Int): CardView? {
        return if (mFragments.isEmpty()) {
            null
        } else {
            mFragments[position].getMCardView()
        }
    }

    private fun addCardFragment(fragment: FavouriteSlideFragment) {
        mFragments.add(fragment)
    }

}