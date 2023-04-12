package com.example.android4lesson1.ui.fragments.manga

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1.R
import com.example.android4lesson1.Resource
import com.example.android4lesson1.base.BaseFragment
import com.example.android4lesson1.databinding.FragmentMangaBinding
import com.example.android4lesson1.ui.adapter.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter()

    override fun initialize() {
        binding.recyclerManga.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error<*> -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading<*> -> {}
                is Resource.Success<*> -> {
                    it.data?.let { it1 ->
                        mangaAdapter.submitList(it1.data)
                    }
                }
            }
        }
    }
}