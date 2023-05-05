package com.example.android4lesson1.data.remote

import com.example.android4lesson1.data.remote.apiserveces.AnimeApiService
import com.example.android4lesson1.data.remote.apiserveces.MangaApiService
import com.example.android4lesson1.data.remote.apiserveces.SignInApiService
import com.example.android4lesson1.data.repositories.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(TokenInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideAnimeApiService(): AnimeApiService {
        return retrofitClient.create(AnimeApiService::class.java)
    }

    fun provideMangaApiService(): MangaApiService{
        return retrofitClient.create(MangaApiService::class.java)
    }
    fun providerSignInApiService(): SignInApiService = retrofitClient.create(SignInApiService::class.java)
}