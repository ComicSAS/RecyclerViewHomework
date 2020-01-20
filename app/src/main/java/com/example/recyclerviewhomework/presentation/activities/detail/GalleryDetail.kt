package com.example.recyclerviewhomework.presentation.activities.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.databinding.ActivityGalleryDetailBinding
import com.example.recyclerviewhomework.presentation.adapter.GalleryImagesAdapter
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Gallery
import kotlinx.android.synthetic.main.activity_gallery_detail.*

class GalleryDetail : AppCompatActivity() {

    var pictureId = 0

    private lateinit var gallery: Gallery

    private lateinit var galleryImagesAdapter: GalleryImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityGalleryDetailBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_gallery_detail)
        title = ""
        val intent = intent
        with(intent) {
            gallery = getParcelableExtra("GALLERY")
            pictureId = getIntExtra("ID", 0)
        }
        galleryImagesAdapter = GalleryImagesAdapter(this, gallery.gallery)
        pager_gallery_detail.adapter = galleryImagesAdapter
        binding.handler = this
        viewPagerArrowIndicator.bind(pager_gallery_detail)
        pager_gallery_indicator_detail.attachToViewPager(pager_gallery_detail)
    }

}
