package com.example.android4lesson1.data.remote

import com.example.android4lesson1.data.remote.apiserveces.AnimeApiService
import com.example.android4lesson1.data.remote.apiserveces.MangaApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideAnimeApiService(): AnimeApiService {
        return retrofitClient.create(AnimeApiService::class.java)
    }

    fun provideMangaApiService(): MangaApiService{
        return retrofitClient.create(MangaApiService::class.java)
    }
}