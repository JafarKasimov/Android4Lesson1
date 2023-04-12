package com.example.android4lesson1.data.remote.apiserveces

import com.example.android4lesson1.models.DataItem
import com.example.android4lesson1.models.ResponseModel
import retrofit2.http.GET

interface AnimeApiService {

    @GET("api/edge/anime")
    suspend fun fitchAnime(): ResponseModel<DataItem>
}