package com.example.movie_mvvm.features.movies.domain.repository

import com.example.movie_mvvm.common.ApiState
import com.example.movie_mvvm.data.model.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovies(): Flow<ApiState<Movies>>

}
