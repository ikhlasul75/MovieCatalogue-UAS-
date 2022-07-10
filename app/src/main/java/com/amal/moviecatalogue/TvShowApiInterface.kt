package com.amal.moviecatalogue

import retrofit2.Call
import retrofit2.http.GET

interface TvShowApiInterface {

    @GET("/3/tv/popular?api_key=da5594aea38b967f0e9ddcace2cbae47")
    fun getTvShowList(): Call<TvShowResponse>
}