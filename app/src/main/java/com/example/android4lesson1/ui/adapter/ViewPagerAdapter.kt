package com.example.android4lesson1.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android4lesson1.ui.fragments.anime.AnimeFragment
import com.example.android4lesson1.ui.fragments.manga.MangaFragment

class ViewPagerAdapter
    (fragmentManager: Fragment) :
    FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AnimeFragment()
            1 -> MangaFragment()
            else -> AnimeFragment()
        }
    }
}
