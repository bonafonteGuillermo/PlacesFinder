package com.upsa.mimo.placesfinder.ui.favourites.utils

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.upsa.mimo.placesfinder.ui.favourites.adapter.FragmentViewPagerAdapter

class CardTransformer(private val mViewPager: ViewPager, private val mAdapter: FragmentViewPagerAdapter) :
    ViewPager.OnPageChangeListener, ViewPager.PageTransformer {
    private var mLastOffset: Float = 0.toFloat()
    private var mScalingEnabled: Boolean = false

    init {
        mViewPager.addOnPageChangeListener(this)
        enableScaling(true)
    }

    private fun enableScaling(enable: Boolean) {
        if (mScalingEnabled && !enable) {
            // shrink main card
            val currentCard = mAdapter.getCardViewAt(mViewPager.currentItem)
            if (currentCard != null) {
                currentCard.animate().scaleY(1f)
                currentCard.animate().scaleX(1f)
            }
        } else if (!mScalingEnabled && enable) {
            // grow main card
            val currentCard = mAdapter.getCardViewAt(mViewPager.currentItem)
            if (currentCard != null) {
                currentCard.animate().scaleY(1.1f)
                currentCard.animate().scaleX(1.1f)
            }
        }
        mScalingEnabled = enable
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        val realCurrentPosition: Int
        val nextPosition: Int
        val realOffset: Float
        val goingLeft = mLastOffset > positionOffset

        // If we're going backwards, onPageScrolled receives the last position
        // instead of the current one
        when {
            position == mAdapter.count - 1 -> {
                realCurrentPosition = position
                nextPosition = position
                realOffset = 1 - positionOffset
            }
            goingLeft -> {
                realCurrentPosition = position + 1
                nextPosition = position
                realOffset = 1 - positionOffset
            }
            else -> {
                nextPosition = position + 1
                realCurrentPosition = position
                realOffset = positionOffset
            }
        }

        // Avoid crash on overscroll
        if (nextPosition > mAdapter.count - 1 || realCurrentPosition > mAdapter.count - 1) {
            return
        }

        val currentCard = mAdapter.getCardViewAt(realCurrentPosition)

        // This might be null if a fragment is being used
        // and the views weren't created yet
        if (currentCard != null) {
            if (mScalingEnabled) {
                currentCard.scaleX = (1 + 0.1 * (1 - realOffset)).toFloat()
                currentCard.scaleY = (1 + 0.1 * (1 - realOffset)).toFloat()
            }
        }

        val nextCard = mAdapter.getCardViewAt(nextPosition)

        // We might be scrolling fast enough so that the next (or previous) card
        // was already destroyed or a fragment might not have been created yet
        if (nextCard != null) {
            if (mScalingEnabled) {
                nextCard.scaleX = (1 + 0.1 * realOffset).toFloat()
                nextCard.scaleY = (1 + 0.1 * realOffset).toFloat()
            }
        }

        mLastOffset = positionOffset
    }

    override fun onPageSelected(position: Int) {}

    override fun onPageScrollStateChanged(state: Int) {}

    override fun transformPage(page: View, position: Float) {}
}