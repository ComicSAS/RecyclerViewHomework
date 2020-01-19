package com.example.recyclerviewhomework.presentation.activities.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.databinding.ActivityDetailBinding
import com.example.recyclerviewhomework.presentation.adapter.GalleryArrayAdapter
import com.example.recyclerviewhomework.presentation.item.IClickListener
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Gallery
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {

    lateinit var name: String
    lateinit var birthDate: String
    lateinit var description: String

    lateinit var galleryList: MutableList<Picture>

    lateinit var user: User

    lateinit var intentGalleryDetail: Intent

    private lateinit var galleryArrayAdapter: GalleryArrayAdapter

    val onItemClick = object : IClickListener<Picture> {
        override fun onItemClick(model: Picture): Boolean {
            val changedGallery = galleryArrayAdapter.getChangedGallery()
            val gallery = user.gallery

            if (galleryList != changedGallery) {
                gallery.gallery.clear()
                gallery.gallery.addAll(changedGallery)
            }

            with(intentGalleryDetail) {
                putExtra("GALLERY", gallery)
                putExtra("ID", model.id)
                startActivity(this)
            }
            return true
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUI()
    }

    private fun setUI() {
        initBinding()
        title = name
        intentGalleryDetail = Intent(this, GalleryDetail::class.java)
        galleryArrayAdapter = GalleryArrayAdapter(onItemClick)
        val columnCount = 3
        val gridLayoutManager = GridLayoutManager(this, columnCount)
        rvDetail.layoutManager = gridLayoutManager
        rvDetail.itemAnimator = DefaultItemAnimator()
        rvDetail.adapter = galleryArrayAdapter
        galleryArrayAdapter.addItems(galleryList)
    }

    private fun initBinding() {
        val intent = intent
        user = intent.getParcelableExtra("user")
        name = user.name
        birthDate = user.birthDate
        description = user.description
        galleryList = user.gallery.gallery
        val binding: ActivityDetailBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.user = user
        binding.detail = this
    }

    override fun onBackPressed() {
        val changedGallery = galleryArrayAdapter.getChangedGallery()
        user.gallery.gallery.clear()
        user.gallery.gallery.addAll(changedGallery)
        val intent = Intent().putExtra("changedUser", user)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun openAvatar(view: View) {
        Log.d("myLogs", "openAvatar")
        val galleryAvatar = Gallery(0, mutableListOf(Picture(0, user.image)))
        intentGalleryDetail.putExtra("GALLERY", galleryAvatar)

        startActivity(intentGalleryDetail)
    }
}



