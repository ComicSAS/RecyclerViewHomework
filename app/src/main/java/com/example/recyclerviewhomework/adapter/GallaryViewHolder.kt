package com.example.recyclerviewhomework.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.databinding.GalleryItemBinding
import com.example.recyclerviewhomework.model.Gallery
import com.example.recyclerviewhomework.presentation.IClickListener

class GallaryViewHolder(var binding: GalleryItemBinding, private val onLongItemClick: IClickListener<Gallery>) : RecyclerView.ViewHolder(binding.root) {

    fun bindPicture(gallery: Gallery) {
        itemView.setOnLongClickListener { onLongItemClick.onItemClick(gallery) }
        binding.gallery = gallery
        binding.executePendingBindings()
    }
}
