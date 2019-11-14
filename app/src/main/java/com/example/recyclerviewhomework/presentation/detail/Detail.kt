package com.example.recyclerviewhomework.presentation.detail

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.adapter.GalleryArrayAdapter
import com.example.recyclerviewhomework.databinding.ActivityDetailBinding
import com.example.recyclerviewhomework.model.DataClass.imageArray
import com.example.recyclerviewhomework.model.Gallery
import com.example.recyclerviewhomework.model.User
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

class Detail : AppCompatActivity() {

    var pictures = imageArray

    var galleryList = ArrayList<Gallery>()

    lateinit var name: String
    lateinit var birthDate: String
    lateinit var description: String
    var uri: Uri? = null

    private val galleryArrayAdapter = GalleryArrayAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUI()
    }

    private fun initGallery() {
        for (i in 0..11) {
            val uri = Uri.parse(pictures[i])
            galleryList.add(Gallery(uri))
        }
    }

    private fun setUI() {
        initBinding()
        Objects.requireNonNull<ActionBar>(supportActionBar).setTitle(name)

        val columnCount = 3
        val gridLayoutManager = GridLayoutManager(this, columnCount)
        rvDetail.layoutManager = gridLayoutManager
        rvDetail.itemAnimator = DefaultItemAnimator()
        rvDetail.adapter = galleryArrayAdapter

        initGallery()
        galleryArrayAdapter.addItems(galleryList)
    }

    fun initBinding() {
        val intent = intent
        uri = intent.data
        name = intent.getStringExtra("name")
        birthDate = intent.getStringExtra("birthDate")
        description = intent.getStringExtra("description")
        val user = User(name, birthDate, description, uri)
        val binding: ActivityDetailBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.user = user
    }
}
