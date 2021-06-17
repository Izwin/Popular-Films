package com.izwin.topmovies.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izwin.topmovies.api.ApiClient
import com.izwin.topmovies.model.MovieModel
import com.izwin.topmovies.utils.Constants.API_KEY
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel(){

    lateinit var context: Context

    val popularMovieList : MutableLiveData<List<MovieModel>> = MutableLiveData()


    fun getPopular(page: Int? = null, region: String? = null, lang: String? = null){
        val apiService = ApiClient.create(context)
        viewModelScope.launch { popularMovieList.postValue(apiService.getTopMovies(API_KEY, lang ?: "ru-Ru" , page , region).results ) }
    }


}