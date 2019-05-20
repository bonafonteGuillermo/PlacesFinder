package com.upsa.mimo.placesfinder.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlacesResults(
    @SerializedName("results") val results: List<Place>,
    @SerializedName("status") val status: Status
): Parcelable

@Parcelize
data class Place(
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("place_id") val placeId: String,
    @SerializedName("reference") val reference: String,
    @SerializedName("scope") val scope: String,
    @SerializedName("types") val types: List<String>,
    @SerializedName("rating") val rating: Float,
    @SerializedName("vicinity") val vicinity: String,
    var isFavourite: Boolean = false
): Parcelable