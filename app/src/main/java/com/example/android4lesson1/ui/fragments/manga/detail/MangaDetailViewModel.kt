package com.example.android4lesson1.ui.fragments.manga.detail

import com.example.android4lesson1.base.BaseViewModel
import com.example.android4lesson1.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel@Inject constructor (
    private val mangaRepository: MangaRepository
) : BaseViewModel() {

    fun fetchMangaDetail(id: String) = mangaRepository.fitchDetailManga(id)
}