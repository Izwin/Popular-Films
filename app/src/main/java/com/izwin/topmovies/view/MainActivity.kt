package com.izwin.topmovies.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.izwin.topmovies.R
import com.izwin.topmovies.adapters.MovieAdapter
import com.izwin.topmovies.model.MovieModel
import com.izwin.topmovies.utils.Constants.MOVIE_EXTRA
import com.izwin.topmovies.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewmodel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel.context = this

        var page = 1

        val layoutManager = LinearLayoutManager(this)
        val adapter = MovieAdapter(this, listOf<MovieModel>()){
            startActivity(Intent(this, MovieDetail::class.java).putExtra(MOVIE_EXTRA, it))
        }

        recycle_view.adapter = adapter
        recycle_view.layoutManager = layoutManager

        recycle_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0){
                    val visibleItemCount = layoutManager.childCount
                    val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val total = layoutManager.itemCount

                    if((visibleItemCount + pastVisibleItem) >= total){
                        page++
                        viewmodel.getPopular(page)
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        viewmodel.getPopular(page)

        viewmodel.popularMovieList.observe(this){
            adapter.addMovies(it)
        }
    }
}