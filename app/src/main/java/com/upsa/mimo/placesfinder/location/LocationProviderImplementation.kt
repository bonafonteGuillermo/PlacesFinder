package com.upsa.mimo.placesfinder.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class LocationProviderImplementation(private val fragment: Fragment) : ILocationProvider {

    companion object {
        private const val UPDATE_INTERVAL : Long = 2000
        private const val FASTEST_INTERVAL: Long = 100
        const val REQUEST_CHECK_SETTINGS = 97
        const val REQUEST_LOCATION_FOR_PLACES = 98
        const val REQUEST_LOCATION = 99
    }

    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private var mLocationRequest: LocationRequest? = null
    private var publisher = PublishSubject.create<Location>()

    init {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(checkNotNull(fragment.context))
        mLocationRequest = createLocationRequest()
    }

    @SuppressLint("MissingPermission")
    private fun startLocationUpdates(){
        mFusedLocationClient?.requestLocationUpdates(mLocationRequest,createLocationCallback(), null)
    }

    private fun createLocationCallback() : LocationCallback {
        return object : LocationCallback() {

            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                publisher.onNext(locationResult.lastLocation)
                mFusedLocationClient?.removeLocationUpdates(this)
            }}
    }

    private fun createLocationRequest() : LocationRequest {
        return LocationRequest.create()
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setInterval(UPDATE_INTERVAL)
            .setFastestInterval(FASTEST_INTERVAL)
    }

    private fun checkLocationPermission(): Boolean {
        return (  ActivityCompat.checkSelfPermission(checkNotNull(fragment.context), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                &&   ActivityCompat.checkSelfPermission(checkNotNull(fragment.context), Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
    }

    private fun requestLocationPermission(requestCode: Int) {
        fragment.requestPermissions(arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION),
            requestCode)
    }

    override fun getMyLocation(): Observable<Location> {
        if(checkLocationPermission()){
            val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest!!)
            val client = LocationServices.getSettingsClient(checkNotNull(fragment.context))
            val task = client.checkLocationSettings(builder.build())

            task.addOnSuccessListener(checkNotNull(fragment.activity)) {
                startLocationUpdates()
            }

            task.addOnFailureListener(checkNotNull(fragment.activity)) { e ->
                if (e is ResolvableApiException) {
                    try {
                        fragment.startIntentSenderForResult(e.resolution.intentSender, REQUEST_CHECK_SETTINGS, null, 0, 0, 0,null)
                    } catch (sendEx: IntentSender.SendIntentException) { }
                }
            }
        }else{
            requestLocationPermission(REQUEST_LOCATION)
        }

        return publisher
    }

    override fun permissionsGranted() {
        startLocationUpdates()
    }
}