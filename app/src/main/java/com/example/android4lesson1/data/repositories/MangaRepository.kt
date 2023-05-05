package com.example.android4lesson1.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.android4lesson1.base.BaseRepository
import com.example.android4lesson1.data.remote.apiserveces.MangaApiService
import com.example.android4lesson1.data.repositories.pagingsource.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) : BaseRepository() {
    fun fetchManga() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                MangaPagingSource(mangaApiService)
            })

    fun fitchDetailManga(id: String) = doRequest {
        mangaApiService.fitchDetailManga(id)
    }
}