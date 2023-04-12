package com.example.android4lesson1.di

import com.example.android4lesson1.data.remote.RetrofitClient
import com.example.android4lesson1.data.remote.apiserveces.AnimeApiService
import com.example.android4lesson1.data.remote.apiserveces.MangaApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiServices() = retrofitClient.provideAnimeApiService()

    @Singleton
    @Provides
    fun provideMangaApiServices() = retrofitClient.provideMangaApiService()
}