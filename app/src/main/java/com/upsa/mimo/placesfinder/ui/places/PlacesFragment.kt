package com.upsa.mimo.placesfinder.ui.places

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector
import com.upsa.mimo.placesfinder.location.LocationProviderImplementation.Companion.REQUEST_CHECK_SETTINGS
import com.upsa.mimo.placesfinder.location.LocationProviderImplementation.Companion.REQUEST_LOCATION
import com.upsa.mimo.placesfinder.utils.showDialog
import kotlinx.android.synthetic.main.fragment_places.*

class PlacesFragment : Fragment(), IPlacesView {

    private lateinit var presenter: IPlacesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_places, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activityInjector = checkNotNull(activity)
        presenter = activityInjector.injector.placesInjector.providesPlacesPresenter(this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            when (requestCode) {
                REQUEST_LOCATION -> presenter.permissionsGranted()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CHECK_SETTINGS ->
                when (resultCode) {
                    Activity.RESULT_OK -> presenter.permissionsGranted()
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoading() {
        places_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        places_loading.visibility = View.GONE
    }

    override fun showErrorDialog() {
        context?.showDialog(
            R.string.dialog__error_title,
            R.string.dialog__error_message
        ) {
            showLoading()
            presenter.requestLocation() }
    }
}
