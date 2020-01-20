package com.example.recyclerviewhomework.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.databinding.ItemGalleryImageBinding
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture

class GalleryImagesAdapter(private val cxt: Context, private val images: List<Picture>) : PagerAdapter() {

    override fun getCount(): Int = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding: ItemGalleryImageBinding = DataBindingUtil.inflate(
                LayoutInflater.from(cxt), R.layout.item_gallery_image, container, false)

        binding.picture = images[position]
        container.addView(binding.root)

        return binding.root
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {

        super.setPrimaryItem(container, position, `object`)

    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }
}