package com.example.recyclerviewhomework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.model.Gallery
import com.example.recyclerviewhomework.presentation.IClickListener
import java.util.*

class GalleryArrayAdapter : RecyclerView.Adapter<GallaryViewHolder>() {

    private val galleryList: ArrayList<Gallery> = ArrayList()

    private val onLongItemClick = object:IClickListener<Gallery>{
        override fun onItemClick(model: Gallery): Boolean {
            removeItem(galleryList.indexOf(model))
            return true
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GallaryViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gallery_item, parent, false)
        return GallaryViewHolder(view, onLongItemClick)
    }

    override fun onBindViewHolder(holder: GallaryViewHolder, position: Int) {
        val gallery = galleryList[position]
        holder.bindPicture(gallery)
    }

    override fun getItemCount(): Int {
        return galleryList.size
    }

    fun addItems(gallery: List<Gallery>?) {
        if (gallery == null)
            return
        else if (gallery.isEmpty())
            return
        else {
            galleryList.addAll(gallery)
            //update state of list inside Adapter
            notifyDataSetChanged()
        }
    }

    fun removeItem(position: Int) {
        galleryList.removeAt(position)
        notifyItemRemoved(position)
    }

}
