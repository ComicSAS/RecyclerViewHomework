package com.example.recyclerviewhomework.utils.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class DataBindingUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("bind:image_url")
        fun loadImage(iv: ImageView, url: String?) {
            Glide.with(iv.context).load(url).circleCrop()
                    .apply(RequestOptions.circleCropTransform()).dontAnimate().into(iv)
        }

        @JvmStatic
        @BindingAdapter("bind:picture_url")
        fun loadPicture(iv: ImageView, url: String?) {
            Glide.with(iv.context).load(url).centerCrop().dontAnimate().into(iv)
        }

        @JvmStatic
        @BindingAdapter("bind:gallery_detail")
        fun galleryDetail(iv: ImageView, url: String?) {
            Glide.with(iv.context).load(url).dontAnimate().fitCenter().into(iv)
        }

        @JvmStatic
        @BindingAdapter("bind:current_item")
        fun currentItem(vp: ViewPager, id: Int) {
            vp.currentItem = id
        }
    }
}