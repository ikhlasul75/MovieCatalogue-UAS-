package com.amal.moviecatalogue

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse(
    @SerializedName("results")
    val tvshow : List<TvShow>

) : Parcelable {
    constructor() : this(mutableListOf())
}