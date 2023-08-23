package com.example.movie_mvvm.di

import com.example.movie_mvvm.data.network.ApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesApiService(moshi: Moshi): ApiService = // Moshi - Coordinates binding between JSON values and Java objects.
        Retrofit.Builder()
            .run {
                baseUrl(ApiService.BASE_URL)
                addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build()
            }.create(ApiService::class.java)
}
