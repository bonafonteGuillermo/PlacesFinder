package com.upsa.mimo.placesfinder.ui.places

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector
import com.upsa.mimo.placesfinder.location.LocationProviderImplementation.Companion.REQUEST_CHECK_SETTINGS
import com.upsa.mimo.placesfinder.location.LocationProviderImplementation.Companion.REQUEST_LOCATION

class PlacesFragment : Fragment(), IPlacesView {

    private lateinit var presenter: IPlacesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d("->", "PlacesFragment_onCreateView")
        return inflater.inflate(R.layout.fragment_places, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("->", "PlacesFragment_onActivityCreated")
        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.placesInjector.providesPlacesPresenter(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("->", "PlacesFragment_onAttach")
    }

    override fun onResume() {
        super.onResume()
        Log.d("->", "PlacesFragment_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("->", "PlacesFragment_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("->", "PlacesFragment_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("->", "PlacesFragment_onDestroy")
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            when (requestCode) {
                REQUEST_LOCATION -> presenter.permissionsGranted()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            REQUEST_CHECK_SETTINGS ->
                when(resultCode){
                    Activity.RESULT_OK -> presenter.permissionsGranted()
                }
        }
    }
}