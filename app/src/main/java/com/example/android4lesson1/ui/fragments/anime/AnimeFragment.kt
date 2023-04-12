package com.example.android4lesson1.ui.fragments.anime

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1.R
import com.example.android4lesson1.Resource
import com.example.android4lesson1.base.BaseFragment
import com.example.android4lesson1.databinding.FragmentAnimeBinding
import com.example.android4lesson1.ui.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()

    override fun initialize() {
        binding.recyclerAnime.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error<*> -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading<*> -> {}
                is Resource.Success<*> -> {
                    it.data?.let { it1 ->
                        animeAdapter.submitList(it1.data)
                    }
                }
            }
        }
    }
}