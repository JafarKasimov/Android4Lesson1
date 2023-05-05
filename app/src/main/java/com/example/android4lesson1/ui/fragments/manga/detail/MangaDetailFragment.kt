package com.example.android4lesson1.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1.R
import com.example.android4lesson1.base.BaseFragment
import com.example.android4lesson1.databinding.FragmentMangaDetailBinding
import com.example.android4lesson1.extensions.setImage
import com.example.android4lesson1.extensions.toast
import com.example.android4lesson1.ui.fragments.anime.detail.AnimeDetailFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupSubscribes() = with(binding){
        viewModel.fetchMangaDetail(args.id).subscribe(
            onError = {
                toast(it)
            },
            onSuccess = { it ->
                it.dataItem.let {
                    itemDetailImg.setImage(it.attributes.posterImage.original)
                    backgroundImg.setImage(it.attributes.posterImage.original)
                    mangaName.text = it.attributes.titles.enJp
                    tvMangaEpisodes.text = it.attributes.episodeCount.toString()
                    tvMangaStatus.text = it.attributes.status
                    tvMangaPremiered.text = it.attributes.startDate
                    tvMangaAgeRating.text = it.attributes.ageRatingGuide
                }
            }
        )
    }
}