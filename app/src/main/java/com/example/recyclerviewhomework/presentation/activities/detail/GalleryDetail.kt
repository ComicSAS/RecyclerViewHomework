package com.example.recyclerviewhomework.presentation.activities.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.presentation.adapter.GalleryImagesAdapter
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Gallery
import kotlinx.android.synthetic.main.activity_gallery_detail.*

class GalleryDetail : AppCompatActivity() {

    private var pictureId = 0

    private lateinit var gallery: Gallery

    private lateinit var viewPager: ViewPager

    private lateinit var galleryImagesAdapter: GalleryImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_detail)
        title = ""
        val intent = intent
        with(intent) {
            gallery = getParcelableExtra("GALLERY")
            pictureId = getIntExtra("ID", 0)
        }
        viewPager = findViewById(R.id.pager_gallery_detail)
        galleryImagesAdapter = GalleryImagesAdapter(this, gallery.gallery)
        viewPager.adapter = galleryImagesAdapter
        viewPager.currentItem = pictureId
        viewPagerArrowIndicator.bind(viewPager)
        pager_gallery_indicator_detail.attachToViewPager(viewPager)

    }
}
