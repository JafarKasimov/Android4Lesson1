package com.example.android4lesson1.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1.R
import com.example.android4lesson1.base.BaseFragment
import com.example.android4lesson1.databinding.FragmentAnimeDetailBinding
import com.example.android4lesson1.extension.setImage
import com.example.android4lesson1.ui.adapter.EpisodeDetailAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeDetailFragment :
    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args: AnimeDetailFragmentArgs by navArgs()
    private val episodeAdapter = EpisodeDetailAdapter()


    override fun setupSubscribes() {
        lifecycleScope.launch {
            viewModel.fetchAnimeDetail(args.id).collect {
                it.data?.dataItem?.attributes?.apply {
                    binding.scrollText.text = description
                    binding.animeName.text = titles.enJp
                    binding.animeImageView.setImage(posterImage.original)
                    binding.backgroundImg.setImage(posterImage.large)
                }
            }
        }
    }
}