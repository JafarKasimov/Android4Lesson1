package com.example.android4lesson1.data.repositories.pagingsource

import android.net.Uri
import com.example.android4lesson1.base.BasePagingSource
import com.example.android4lesson1.data.remote.apiserveces.AnimeApiService
import com.example.android4lesson1.models.DataItem

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class AnimePagingSources(private val animeApiService: AnimeApiService) :
    BasePagingSource< DataItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val nextPage = params.key ?: CHARACTER_STARTING_PAGE_INDEX
            val response = animeApiService.fitchAnime(params.loadSize, nextPage)
            val nextPages =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()

            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}