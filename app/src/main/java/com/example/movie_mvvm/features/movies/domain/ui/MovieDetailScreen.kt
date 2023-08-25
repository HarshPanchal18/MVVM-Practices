package com.example.movie_mvvm.features.movies.domain.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.movie_mvvm.R
import com.example.movie_mvvm.data.network.ApiService
import com.example.movie_mvvm.features.movies.ui.MovieViewModel

@Composable
fun MovieDetailScreen(viewModel: MovieViewModel) {

    val response = viewModel.movieDetail.value
    Log.d("detail", "Movie: ${response.original_title}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("${ApiService.IMAGE_URL}${response.poster_path ?: ""}")
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .crossfade(true)
                    .build()
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(300.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(text = response.original_title ?: "-", style = MaterialTheme.typography.headlineMedium)
        Text(text = response.vote_average ?: "0", style = MaterialTheme.typography.titleMedium)
        Text(text = response.overview ?: "0", style = MaterialTheme.typography.titleMedium)
    }
}
