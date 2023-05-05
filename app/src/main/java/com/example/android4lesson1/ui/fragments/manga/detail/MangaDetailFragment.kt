package com.example.android4lesson1.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1.R
import com.example.android4lesson1.base.BaseFragment
import com.example.android4lesson1.databinding.FragmentMangaDetailBinding
import com.example.android4lesson1.extension.setImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args: MangaDetailFragmentArgs by navArgs()

    override fun setupSubscribes() {
        lifecycleScope.launch {
            viewModel.fetchMangaDetail(args.id).collect() {
                it.data?.dataItem?.attributes?.apply {
                    binding.scrollText.text = description
                    binding.mangaImageView.setImage(posterImage.original)
                    binding.backgroundImg.setImage(posterImage.large)
                }
            }
        }
    }
}