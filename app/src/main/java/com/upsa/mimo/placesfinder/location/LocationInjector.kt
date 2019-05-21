package com.upsa.mimo.placesfinder.location

import androidx.fragment.app.Fragment

class LocationInjector {
    fun getInstanceLocationProvider(fragment: Fragment) : ILocationProvider = LocationProviderImplementation(fragment)
}