package com.upsa.mimo.placesfinder.location

import androidx.fragment.app.Fragment

class LocationInjector {
    fun providesLocationProvider(fragment: Fragment) : ILocationProvider = LocationProviderImplementation(fragment)
}