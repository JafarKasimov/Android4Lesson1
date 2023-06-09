package com.example.android4lesson1.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1.R
import com.example.android4lesson1.base.BaseFragment
import com.example.android4lesson1.databinding.FragmentAnimeBinding
import com.example.android4lesson1.ui.adapter.AnimeAdapter
import com.example.android4lesson1.ui.fragments.home.HomeFragment
import com.example.android4lesson1.ui.fragments.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onItemClick)

    override fun initializes() {
        binding.recyclerAnime.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToAnimeDetailFragment(
                id
            )
        )
    }
}