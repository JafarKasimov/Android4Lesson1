package com.example.android4lesson1.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android4lesson1.base.BaseRepository
import com.example.android4lesson1.data.remote.apiserveces.AnimeApiService
import com.example.android4lesson1.data.repositories.pagingsource.AnimePagingSources
import com.example.android4lesson1.data.repositories.pagingsource.MangaPagingSource
import com.example.android4lesson1.models.DataItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) : BaseRepository() {

    fun fetchAnime() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                AnimePagingSources(animeApiService)
            })
}