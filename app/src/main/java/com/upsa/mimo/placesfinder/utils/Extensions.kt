package com.upsa.mimo.placesfinder.utils

import android.location.Location
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.upsa.mimo.placesfinder.model.Place

fun Location.getLocationQueryParam(): String {
    val sb = StringBuilder()
    sb.append(this.latitude).append(",").append(this.longitude)
    return sb.toString()
}

fun ImageView.setStaticMapImage(place: Place) {
    Glide
        .with(this.context)
        .load("https://maps.googleapis.com/maps/api/staticmap?center=${place.geometry.location.lat}%2c%20${place.geometry.location.lng}&zoom=16&size=400x400&scale=2x400&markers=color:blue%7C${place.geometry.location.lat},${place.geometry.location.lng}&key=AIzaSyANHdY3Bxr-Oc6_FjXpZTskCXz65uV_gaE")
        .centerCrop()
        .into(this)
}

fun RatingBar.setPlaceRatingValue(progressValue: Float) {
    with(this) {
        progress = progressValue.toInt()
        setIsIndicator(true)
    }
}

fun TextView.setTotalReviews(stringTotalReviews: String) {
    text = stringTotalReviews
}

