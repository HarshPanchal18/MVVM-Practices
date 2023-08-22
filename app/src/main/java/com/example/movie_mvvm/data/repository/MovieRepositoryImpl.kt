package com.example.movie_mvvm.data.repository

import com.example.movie_mvvm.common.ApiState
import com.example.movie_mvvm.common.base.BaseRepository
import com.example.movie_mvvm.data.model.Movies
import com.example.movie_mvvm.data.network.ApiService
import com.example.movie_mvvm.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository, BaseRepository() {
    override suspend fun getMovies(): Flow<ApiState<Movies>> = safeApiCall {
        apiService.getMovies()
    }
}
