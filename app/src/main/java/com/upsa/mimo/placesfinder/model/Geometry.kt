package com.upsa.mimo.placesfinder.model

import android.os.Parcelable
import androidx.room.Embedded
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Geometry(
    @Embedded
    val location: Location
) : Parcelable