package com.example.movie_mvvm.data.model

data class Movies(
    val page: Int?,
    val totalPages: Int?,
    val results: List<Results>,
    val totalResults: Int?
) {
    data class Results(
        val overview: String? = null,
        val originalLanguage: String? = null,
        val originalTitle: String? = null,
        val video: Boolean? = null,
        val title: String? = null,
        val genreIds: List<Int?>? = null,
        val posterPath: String? = null,
        val backdropPath: String? = null,
        val releaseDate: String? = null,
        val popularity: Any? = null,
        val voteAverage: Any? = null,
        val id: Int? = null,
        val adult: Boolean? = null,
        val voteCount: Int? = null
    )
}
