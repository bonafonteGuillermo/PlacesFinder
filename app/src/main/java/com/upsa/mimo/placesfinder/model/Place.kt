package com.upsa.mimo.placesfinder.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "place")
data class Place(

    @PrimaryKey
    val id: String?,

    val name: String?,

    @SerializedName("place_id")
    @ColumnInfo(name = "place_id")
    val placeId: String?,

    val types: List<String>?,

    @SerializedName("price_level")
    @ColumnInfo(name = "price_level")
    val priceLevel: Int?,

    val rating: Float?,

    @SerializedName("user_ratings_total")
    @ColumnInfo(name = "user_ratings_total")
    val userRatingTotal: Int?,

    val vicinity: String?,

    var isFavourite: Boolean = false
): Parcelable