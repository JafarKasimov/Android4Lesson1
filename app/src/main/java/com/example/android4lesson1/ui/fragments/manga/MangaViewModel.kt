package com.example.android4lesson1.ui.fragments.manga

import androidx.lifecycle.ViewModel
import com.example.android4lesson1.data.repositories.AnimeRepository
import com.example.android4lesson1.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor (
    val mangaRepository: MangaRepository
) : ViewModel() {

    fun fetchManga() = mangaRepository.fetchManga()
}