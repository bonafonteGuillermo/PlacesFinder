package com.upsa.mimo.placesfinder.model

import android.os.Parcelable
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "place")
@TypeConverters(PlaceConverter::class)
data class Place(

    val name: String?,

    @PrimaryKey
    @SerializedName("place_id")
    @ColumnInfo(name = "place_id")
    val placeId: String,

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
) : Parcelable

class PlaceConverter {
    @TypeConverter
    fun fromList(types: List<String>?): String = GsonBuilder().create().toJson(types)

    @TypeConverter
    fun fromJson(json: String?): List<String> = Gson().fromJson(json, Array<String>::class.java).toList()

}