package com.example.movie_mvvm.features.movies.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_mvvm.common.onFailure
import com.example.movie_mvvm.common.onLoading
import com.example.movie_mvvm.common.onSuccess
import com.example.movie_mvvm.data.model.Movies
import com.example.movie_mvvm.features.movies.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: MovieUseCase
) : ViewModel() {

    private val _response: MutableState<MovieState> = mutableStateOf(MovieState())
    val response = _response

    init {
        viewModelScope.launch {
            useCase.getMovies()
                .onSuccess {
                    _response.value = MovieState(data = it!!)
                }
                .onFailure {
                    _response.value = MovieState(error = it?.message!!)
                }
                .onLoading {
                    _response.value = MovieState(isLoading = true)
                }.collect()
        }
    }

}

data class MovieState(
    val data: List<Movies.Results> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
