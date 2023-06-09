package com.example.android4lesson1.ui.fragments.anime.detail

import com.example.android4lesson1.base.BaseViewModel
import com.example.android4lesson1.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel@Inject constructor (
    private val animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchAnimeDetail(id: String) = animeRepository.fitchDetailAnime(id)
}