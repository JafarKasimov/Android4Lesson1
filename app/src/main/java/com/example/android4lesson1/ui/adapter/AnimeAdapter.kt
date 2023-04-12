package com.example.android4lesson1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson1.databinding.ItemAnimeBinding
import com.example.android4lesson1.extension.setImage
import com.example.android4lesson1.models.DataItem

class AnimeAdapter : ListAdapter<DataItem, AnimeAdapter.ViewHolder>(
    AnimeDiffCallBack
) {
    inner class ViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: DataItem) {
            binding.itemNameTv.text = item.attributes.titles.enJp
            binding.itemAnimeImage.setImage(item.attributes.posterImage.large)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeAdapter.ViewHolder {
        return ViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeAdapter.ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

object AnimeDiffCallBack : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(
        oldItem: DataItem,
        newItem: DataItem,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: DataItem,
        newItem: DataItem,
    ): Boolean {
        return oldItem.id == newItem.id
    }
}