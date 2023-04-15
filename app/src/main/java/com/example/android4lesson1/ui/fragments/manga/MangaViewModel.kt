package com.example.android4lesson1.ui.fragments.manga

import androidx.paging.liveData
import com.example.android4lesson1.base.BaseViewModel
import com.example.android4lesson1.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor (
    private val mangaRepository: MangaRepository
) : BaseViewModel() {

    fun fetchManga() = mangaRepository.fetchManga().liveData
}