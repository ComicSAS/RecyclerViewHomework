package com.example.recyclerviewhomework.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.model.Gallery

class GallaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var ivPicture: ImageView

    init {
        ivPicture = itemView.findViewById(R.id.ivPicture)
    }

    fun bindPicture(gallery: Gallery) {
        Glide.with(itemView.context)
                .load(gallery.picture).dontAnimate().into(ivPicture)
    }
}
