package com.example.android4lesson1.data.repositories.pagingsource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.android4lesson1.base.BasePagingSource
import com.example.android4lesson1.data.remote.apiserveces.MangaApiService
import com.example.android4lesson1.models.DataItem
import java.io.IOException

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class MangaPagingSource(private val mangaApiService: MangaApiService) :
    BasePagingSource<DataItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val nextPage = params.key ?: CHARACTER_STARTING_PAGE_INDEX
            val response = mangaApiService.fitchManga(params.loadSize, nextPage)
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