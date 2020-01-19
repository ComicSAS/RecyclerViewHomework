package com.example.recyclerviewhomework.presentation.item

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.databinding.GalleryItemBinding
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture

class GallaryViewHolder(var binding: GalleryItemBinding, private val onLongItemClick: IClickListener<Picture>,
                        private val onItemClick: IClickListener<Picture>) : RecyclerView.ViewHolder(binding.root) {

    fun bindPicture(picture: Picture) {
        itemView.setOnLongClickListener { onLongItemClick.onItemClick(picture) }
        itemView.setOnClickListener { onItemClick.onItemClick(picture) }
        binding.picture = picture
        binding.executePendingBindings()
    }
}
