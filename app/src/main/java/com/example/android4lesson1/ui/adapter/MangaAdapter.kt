package com.example.android4lesson1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson1.databinding.ItemMangaBinding
import com.example.android4lesson1.extension.setImage
import com.example.android4lesson1.models.DataItem

class MangaAdapter : ListAdapter<DataItem, MangaAdapter.ViewHolder>(
    MangaDiffCallBack
) {
    inner class ViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: DataItem) {
            binding.itemNameMangaTv.text = item.attributes.titles.enJp
            binding.itemMangaImage.setImage(item.attributes.posterImage.large)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaAdapter.ViewHolder {
        return ViewHolder(
            ItemMangaBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MangaAdapter.ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

object MangaDiffCallBack : DiffUtil.ItemCallback<DataItem>() {
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