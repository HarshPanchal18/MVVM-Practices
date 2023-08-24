package com.example.movie_mvvm.features.movies.domain.mapper

import com.example.movie_mvvm.common.base.Mapper
import com.example.movie_mvvm.data.model.Movies
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<Movies?, List<Movies.Results>?> {
    override fun fromMap(from: Movies?): List<Movies.Results>? {
        return from?.results?.map { data ->
            data.apply {
                Movies.Results(
                    id = id,
                    original_language = original_language,
                    overview = overview,
                    poster_path = poster_path,
                    vote_average = vote_average
                )
            }
        }
    }
}
