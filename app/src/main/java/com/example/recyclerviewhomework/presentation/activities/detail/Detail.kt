package com.example.recyclerviewhomework.presentation.activities.detail

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.databinding.ActivityDetailBinding
import com.example.recyclerviewhomework.presentation.adapter.GalleryArrayAdapter
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Gallery
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.model.DataClass.imageArray
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*
import kotlin.collections.ArrayList

class Detail : AppCompatActivity() {

//    var pictures = imageArray

    lateinit var galleryList:MutableList<Picture>

    lateinit var name: String
    lateinit var birthDate: String
    lateinit var description: String
    lateinit var uri: Uri

    private val galleryArrayAdapter = GalleryArrayAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUI()
    }

//    private fun initGallery() {
//        for (i in 0..11) {
//            val uri = Uri.parse(pictures[i])
//            galleryList.add(Gallery(0, uri))
//        }
//    }

    private fun setUI() {
        initBinding()
        Objects.requireNonNull<ActionBar>(supportActionBar).title = name

        val columnCount = 3
        val gridLayoutManager = GridLayoutManager(this, columnCount)
        rvDetail.layoutManager = gridLayoutManager
        rvDetail.itemAnimator = DefaultItemAnimator()
        rvDetail.adapter = galleryArrayAdapter

//        initGallery()
        galleryArrayAdapter.addItems(galleryList)
    }

    private fun initBinding() {
        val intent = intent
//        val id = intent.getIntExtra("ID", 0)
//        uri = intent.data
//        name = intent.getStringExtra("name")
//        birthDate = intent.getStringExtra("birthDate")
//        description = intent.getStringExtra("description")
        val user: User = intent.getParcelableExtra("user")
        name = user.name
        birthDate = user.birthDate
        description = user.description
        galleryList = user.gallery.gallery
        val binding: ActivityDetailBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.user = user
    }
}
