package com.upsa.mimo.placesfinder.location

import androidx.fragment.app.Fragment

object LocationInjector {
    fun providesLocationProvider(fragment: Fragment) : ILocationProvider = LocationProviderImplementation(fragment)
}