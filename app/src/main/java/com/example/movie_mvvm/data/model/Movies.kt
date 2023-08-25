package com.example.movie_mvvm.data.model

data class Movies(
    val page: Int?,
    val total_pages: Int?,
    val results: List<Results>,
    val total_results: Int?
) {
    data class Results(
        val overview: String? = null,
        val original_language: String? = null,
        val original_title: String? = null,
        val video: Boolean? = null,
        val title: String? = null,
        val genre_ids: List<Int?>? = null,
        val poster_path: String? = null,
        val backdrop_path: String? = null,
        val release_date: String? = null,
        val popularity: String? = null,
        val vote_average: String? = null,
        val id: Int? = null,
        val adult: Boolean? = null,
        val vote_count: Int? = null
    )
}
