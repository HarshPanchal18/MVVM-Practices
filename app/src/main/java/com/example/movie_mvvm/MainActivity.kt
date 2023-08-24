package com.example.movie_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.movie_mvvm.features.movies.ui.MovieScreen
import com.example.movie_mvvm.ui.theme.MoviemvvmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Marks an Android component class to be setup for injection with the standard Hilt Dagger Android components.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviemvvmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MovieScreen()
                }
            }
        }
    }
}
