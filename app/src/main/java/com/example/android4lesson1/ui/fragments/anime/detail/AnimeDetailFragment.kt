package com.example.android4lesson1.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1.R
import com.example.android4lesson1.base.BaseFragment
import com.example.android4lesson1.databinding.FragmentAnimeDetailBinding
import com.example.android4lesson1.extensions.setImage
import com.example.android4lesson1.extensions.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment :
    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupSubscribes() = with(binding){
        viewModel.fetchAnimeDetail(args.id).subscribe(
            onError = {
                toast(it)
            },
            onSuccess = { it ->
                it.dataItem.let {
                    itemDetailImg.setImage(it.attributes.posterImage.original)
                    backgroundImg.setImage(it.attributes.posterImage.original)
                    animeName.text = it.attributes.titles.enJp
                    tvAnimeEpisodes.text = it.attributes.episodeCount.toString()
                    tvAnimeStatus.text = it.attributes.status
                    tvAnimePremiered.text = it.attributes.startDate
                    tvAnimeAgeRating.text = it.attributes.ageRatingGuide
                }
            }
        )
    }
}