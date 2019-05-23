package com.upsa.mimo.placesfinder.ui.favourites

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector


class FavouritesFragment : Fragment(), IFavouritesView {

    private lateinit var presenter: IFavouritesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d("->", "FavouritesFragment_onCreateView")
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("->", "FavouritesFragment_onActivityCreated")
        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.favouritesInjector.providesFavouritesPresenter(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("->", "FavouritesFragment_onAttach")
    }

    override fun onResume() {
        super.onResume()
        Log.d("->", "FavouritesFragment_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("->", "FavouritesFragment_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("->", "FavouritesFragment_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("->", "FavouritesFragment_onDestroy")
    }
}