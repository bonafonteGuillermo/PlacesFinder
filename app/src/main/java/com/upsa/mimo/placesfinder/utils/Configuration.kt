package com.upsa.mimo.placesfinder.utils

import com.upsa.mimo.placesfinder.BuildConfig

class Configuration {
    val baseUrl : String = "https://maps.googleapis.com/maps/api/"
    val apiKey : String = BuildConfig.GoogleSecAPIKEY
}