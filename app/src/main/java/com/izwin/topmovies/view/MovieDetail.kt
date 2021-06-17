package com.izwin.topmovies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.izwin.topmovies.R
import com.izwin.topmovies.model.MovieModel
import com.izwin.topmovies.utils.Constants
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movie = (intent.extras?.get(Constants.MOVIE_EXTRA) as MovieModel)

        average.text = movie.vote_average.toString()
        movie_title.text = movie.title
        desc.text = movie.overview
        is_adult.isVisible = movie.isAdult

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${movie.url}")
            .into(photo)
    }
}