package com.example.recyclerviewhomework.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.databinding.GalleryItemBinding
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Gallery
import com.example.recyclerviewhomework.presentation.item.IClickListener

class GallaryViewHolder(var binding: GalleryItemBinding, private val onLongItemClick: IClickListener<Gallery>) : RecyclerView.ViewHolder(binding.root) {

    fun bindPicture(gallery: Gallery) {
        itemView.setOnLongClickListener { onLongItemClick.onItemClick(gallery) }
        binding.gallery = gallery
        binding.executePendingBindings()
    }
}
