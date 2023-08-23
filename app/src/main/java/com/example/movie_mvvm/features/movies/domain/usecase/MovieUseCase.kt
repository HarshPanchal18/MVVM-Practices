package com.example.movie_mvvm.features.movies.domain.usecase

import com.example.movie_mvvm.common.ApiState
import com.example.movie_mvvm.common.map
import com.example.movie_mvvm.data.model.Movies
import com.example.movie_mvvm.features.movies.domain.mapper.MovieMapper
import com.example.movie_mvvm.features.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val repo: MovieRepository,
    private val mapper: MovieMapper
) {

    suspend fun getMovies(): Flow<ApiState<List<Movies.Results>?>> {
        return repo.getMovies().map { res ->
            res.map { mapper.fromMap(it) }
        }
    }

}
