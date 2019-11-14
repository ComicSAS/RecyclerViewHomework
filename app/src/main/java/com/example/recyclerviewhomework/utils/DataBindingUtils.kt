package com.example.recyclerviewhomework.utils

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


object DataBindingUtils {
    @JvmStatic
    @BindingAdapter("bind:image_url")
    fun loadImage(iv: ImageView, url: Uri?) {
        Glide.with(iv.context).load(url).circleCrop()
                .apply(RequestOptions.circleCropTransform()).dontAnimate().into(iv)
    }
}