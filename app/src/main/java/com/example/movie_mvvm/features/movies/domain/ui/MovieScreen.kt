package com.example.movie_mvvm.features.movies.domain.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.movie_mvvm.R
import com.example.movie_mvvm.data.model.Movies
import com.example.movie_mvvm.data.network.ApiService
import com.example.movie_mvvm.features.movies.domain.navigation.MovieNavigationItems
import com.example.movie_mvvm.features.movies.ui.MovieViewModel

@Composable
fun MovieScreen(
    viewModel: MovieViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val response = viewModel.response.value

    if (response.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Center) {
            CircularProgressIndicator()
        }
    }

    if (response.error.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Center) {
            Text(text = response.error)
        }
    }

    if (response.data.isNotEmpty()) {
        LazyColumn {
            items(response.data,
                key = { it.id!! }
            ) { result ->
                MovieCard(result = result) {
                    viewModel.setMovie(result)
                    navHostController.navigate(MovieNavigationItems.MovieDetails.route)
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(
    result: Movies.Results,
    onGettingClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(8.dp),
        onClick = { onGettingClick() }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("${ApiService.IMAGE_URL}${result.poster_path}")
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(CenterVertically)
            ) {
                Text(
                    text = result.original_title!!,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "(${result.title!!})",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = result.overview!!,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}
