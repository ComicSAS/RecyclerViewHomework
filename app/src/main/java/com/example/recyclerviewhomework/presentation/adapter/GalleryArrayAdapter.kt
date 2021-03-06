package com.example.recyclerviewhomework.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.databinding.GalleryItemBinding
import com.example.recyclerviewhomework.presentation.item.GallaryViewHolder
import com.example.recyclerviewhomework.presentation.item.IClickListener
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture

class GalleryArrayAdapter(private val onItemClick: IClickListener<Picture>) : RecyclerView.Adapter<GallaryViewHolder>() {

    private val galleryList: MutableList<Picture> = mutableListOf()

    private val onLongItemClick = object : IClickListener<Picture> {
        override fun onItemClick(model: Picture): Boolean {
            removeItem(galleryList.indexOf(model))
            galleryList.forEach {
                if (it.id > model.id)
                    it.id--
            }
            return true
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GallaryViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding: GalleryItemBinding = DataBindingUtil.inflate(view, R.layout.gallery_item, parent, false)
        return GallaryViewHolder(binding, onLongItemClick, onItemClick)
    }

    override fun onBindViewHolder(holder: GallaryViewHolder, position: Int) {
        val picture = galleryList[position]
        holder.bindPicture(picture)
    }

    override fun getItemCount(): Int {
        return galleryList.size
    }

    fun addItems(gallery: MutableList<Picture>) {
        when {
            gallery.isNullOrEmpty() -> return
            else -> {
                galleryList.addAll(gallery)
                //update state of list inside Adapter
                notifyDataSetChanged()
            }
        }
    }

    fun removeItem(position: Int) {
        galleryList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getChangedGallery(): MutableList<Picture> = galleryList

}
