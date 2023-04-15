package com.example.android4lesson1.ui.fragments.anime

import androidx.paging.liveData
import com.example.android4lesson1.base.BaseViewModel
import com.example.android4lesson1.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor (
     private val animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime().liveData
}