package com.example.recyclerviewhomework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.model.Gallery

import java.util.ArrayList

class GalleryArrayAdapter : RecyclerView.Adapter<GallaryViewHolder>(), View.OnLongClickListener {

    private val galleryList: ArrayList<Gallery>?

    init {
        this.galleryList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GallaryViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.gallery_item, parent, false)
        val holder = GallaryViewHolder(view)
        holder.ivPicture.setOnLongClickListener(this@GalleryArrayAdapter)

        holder.ivPicture.tag = holder
        return holder
    }

    override fun onBindViewHolder(holder: GallaryViewHolder, position: Int) {
        val gallery = galleryList!![position]
        holder.bindPicture(gallery)
    }

    override fun getItemCount(): Int {
        return galleryList?.size ?: 0
    }

    fun addItems(gallery: List<Gallery>?) {
        if (gallery == null)
            return
        else if (gallery.isEmpty())
            return
        else {
            galleryList!!.addAll(gallery)
            //update state of list inside Adapter
            notifyDataSetChanged()
        }
    }

    fun removeItem(position: Int) {
        galleryList!!.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onLongClick(v: View): Boolean {
        val holder = v.tag as GallaryViewHolder
        removeItem(holder.position)
        return false
    }
}
