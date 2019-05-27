package com.upsa.mimo.placesfinder.di

import androidx.fragment.app.Fragment
import com.upsa.mimo.placesfinder.location.ILocationProvider
import com.upsa.mimo.placesfinder.location.LocationProviderImplementation

object LocationInjector {
    fun providesLocationProvider(fragment: Fragment) : ILocationProvider =
        LocationProviderImplementation(fragment)
}