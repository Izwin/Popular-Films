package com.izwin.topmovies.api

import com.izwin.topmovies.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular/")
    suspend fun getTopMovies(@Query("api_key") apiKey: String, @Query("language") lang: String? = null, @Query("page") page: Int? = null,@Query("region") region: String? = null): MovieResponse
}