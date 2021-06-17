package com.izwin.topmovies.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MovieModel(
    @SerializedName("adult")
    val isAdult: Boolean,
    @SerializedName("poster_path")
    val url_poster: String,
    @SerializedName("backdrop_path")
    val url: String,
    val title: String,
    val overview: String,
    val vote_average: Double
) : Serializable
