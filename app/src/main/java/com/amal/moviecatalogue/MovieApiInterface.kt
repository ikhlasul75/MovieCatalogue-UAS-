package com.amal.moviecatalogue

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=da5594aea38b967f0e9ddcace2cbae47")

    fun getMovieList(): Call<MovieResponse>
}