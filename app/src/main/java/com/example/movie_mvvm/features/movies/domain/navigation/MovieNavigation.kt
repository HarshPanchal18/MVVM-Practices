package com.example.movie_mvvm.features.movies.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movie_mvvm.features.movies.domain.ui.MovieDetailScreen
import com.example.movie_mvvm.features.movies.domain.ui.MovieScreen
import com.example.movie_mvvm.features.movies.ui.MovieViewModel

@Composable
fun MovieNavigation(viewModel: MovieViewModel) {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = MovieNavigationItems.MovieList.route
    ) {
        composable(MovieNavigationItems.MovieList.route) {
            MovieScreen(viewModel = viewModel, navHostController = navHostController)
        }
        composable(MovieNavigationItems.MovieDetails.route) {
            MovieDetailScreen(viewModel = viewModel)
        }
    }
}

sealed class MovieNavigationItems(val route: String) {
    object MovieList : MovieNavigationItems("movieList")
    object MovieDetails : MovieNavigationItems("movieDetails")
}
