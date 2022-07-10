package com.amal.moviecatalogue

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow (
    @SerializedName("id")
    val id : String ?,

    @SerializedName("name")
    val name : String ?,

    @SerializedName("poster_path")
    val poster : String ?,

    @SerializedName("release_date")
    val release : String ?,

    @SerializedName("overview")
    val overview : String ?,

    @SerializedName("popularity")
    val popularity : String ?

) : Parcelable {
    constructor() : this("", "", "", "","", "")
}