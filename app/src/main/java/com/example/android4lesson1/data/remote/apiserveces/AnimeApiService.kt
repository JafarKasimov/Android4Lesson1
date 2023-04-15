package com.example.android4lesson1.data.remote.apiserveces

import com.example.android4lesson1.models.DataItem
import com.example.android4lesson1.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("api/edge/anime")
    suspend fun fitchAnime(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ): ResponseModel<DataItem>
}