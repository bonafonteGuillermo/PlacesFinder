package com.upsa.mimo.placesfinder.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlacesResults(
    @SerializedName("results") val results: List<Place>,
    @SerializedName("status") val status: Status
): Parcelable