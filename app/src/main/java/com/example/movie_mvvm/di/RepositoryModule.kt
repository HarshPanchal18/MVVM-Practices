package com.example.movie_mvvm.di

import com.example.movie_mvvm.data.repository.MovieRepositoryImpl
import com.example.movie_mvvm.features.movies.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class) // Scope
abstract class RepositoryModule {

    @Binds
    abstract fun provideMovieRepository(repo: MovieRepositoryImpl): MovieRepository

}
