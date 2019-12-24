package com.example.recyclerviewhomework.utils.binding

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
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
    }

}