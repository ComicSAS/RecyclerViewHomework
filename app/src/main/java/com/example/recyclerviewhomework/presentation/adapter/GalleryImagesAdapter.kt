package com.example.recyclerviewhomework.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture

class GalleryImagesAdapter(private val mContext: Context, private val mImages: List<Picture>) : PagerAdapter() {

    override fun getCount(): Int = mImages.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageLayout = LayoutInflater.from(mContext).inflate(R.layout.item_gallery_image, container, false)
        val imageView: ImageView = imageLayout.findViewById(R.id.iv_gallery_image)

        Glide.with(mContext)
                .load(mImages[position].picture)
                .dontAnimate()
                .fitCenter()
                .into(imageView)

        container.addView(imageLayout)

        return imageLayout
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