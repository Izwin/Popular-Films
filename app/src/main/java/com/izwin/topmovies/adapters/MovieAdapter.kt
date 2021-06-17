package com.izwin.topmovies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.izwin.topmovies.R
import com.izwin.topmovies.model.MovieModel
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(val context: Context, var movies: List<MovieModel>, val clickListener: (MovieModel) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies?.get(position)

        holder.title.text = movie?.title
        holder.is_adult.isVisible = movie?.isAdult == true
        holder.itemView.setOnClickListener { clickListener?.invoke(movie) }
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500${movie.url_poster}")
            .into(holder.photo)


    }

    override fun getItemCount(): Int {
        return movies?.size ?: 0
    }

    fun addMovies(list: List<MovieModel>) {
        movies = movies + list
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val photo = itemView.photo
        val title = itemView.movie_title
        val is_adult = itemView.is_adult
    }

}