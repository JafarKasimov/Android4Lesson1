package com.example.android4lesson1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson1.databinding.ItemEpisodeBinding
import com.example.android4lesson1.models.DataItem

class EpisodeDetailAdapter() :
    PagingDataAdapter<DataItem, EpisodeDetailAdapter.ViewHolder>(
        DetailDiffCallBack
    ) {
    inner class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: DataItem) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeDetailAdapter.ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodeDetailAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    object DetailDiffCallBack : DiffUtil.ItemCallback<DataItem>() {
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
}