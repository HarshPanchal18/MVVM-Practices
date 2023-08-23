package com.example.movie_mvvm.data.network

import com.example.movie_mvvm.data.model.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
        const val apiKey = "2c2f00da593005799f2f1ecb3f773145"
    }

    @GET("discover/movie?api_key=${apiKey}")
    suspend fun getMovies(): Response<Movies>
}
