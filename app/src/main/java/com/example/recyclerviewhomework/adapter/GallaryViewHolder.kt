package com.example.recyclerviewhomework.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.model.Gallery
import com.example.recyclerviewhomework.presentation.IClickListener

class GallaryViewHolder(itemView: View, private val onLongItemClick: IClickListener<Gallery>) : RecyclerView.ViewHolder(itemView) {

    var ivPicture: ImageView

    init {
        ivPicture = itemView.findViewById(R.id.ivPicture)
    }

    fun bindPicture(gallery: Gallery) {
        itemView.setOnLongClickListener { onLongItemClick.onItemClick(gallery) }
        Glide.with(itemView.context)
                .load(gallery.picture).dontAnimate().into(ivPicture)
    }
}
