package com.example.android4lesson1.data.repositories

import androidx.lifecycle.liveData
import com.example.android4lesson1.Resource
import com.example.android4lesson1.data.remote.apiserveces.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) {
    fun fetchAnime() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(animeApiService.fitchAnime()))
        }catch (exception: Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}