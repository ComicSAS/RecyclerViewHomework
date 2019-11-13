package com.example.recyclerviewhomework.presentation.detail

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.adapter.GalleryArrayAdapter
import com.example.recyclerviewhomework.model.DataClass.imageArray
import com.example.recyclerviewhomework.model.Gallery
import com.example.recyclerviewhomework.presentation.IClickListener
import java.util.*

class Detail : AppCompatActivity() {

    var pictures = imageArray

    var galleryList = ArrayList<Gallery>()

    lateinit var tvDescription: TextView
    lateinit var tvBirthDate: TextView

    lateinit var ivAvatar: ImageView

    lateinit var recyclerView: RecyclerView

    lateinit var name: String
    lateinit var birthDate: String
    lateinit var description: String


    private val onLongItemClick = object : IClickListener<Gallery> {
        override fun onItemClick(model: Gallery): Boolean {
            galleryArrayAdapter.removeItem(galleryList.indexOf(model))
            return true
        }
    }
    private val galleryArrayAdapter = GalleryArrayAdapter()

    var uri: Uri? = null

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
        val intent = intent
        uri = intent.data
        name = intent.getStringExtra("name")
        birthDate = intent.getStringExtra("birthDate")
        description = intent.getStringExtra("description")

        tvDescription = findViewById(R.id.tvDetailDescription)
        tvBirthDate = findViewById(R.id.tvDetailBirthDate)
        ivAvatar = findViewById(R.id.ivDetailAvatar)
        recyclerView = findViewById(R.id.rvDetail)

        Objects.requireNonNull<ActionBar>(supportActionBar).setTitle(name)
        Glide.with(this).load(uri).circleCrop()
                .apply(RequestOptions.circleCropTransform()).dontAnimate().into(ivAvatar)
        tvBirthDate.text = birthDate
        tvDescription.text = description

        val columnCount = 3
        val gridLayoutManager = GridLayoutManager(this, columnCount)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = galleryArrayAdapter

        initGallery()
        galleryArrayAdapter.addItems(galleryList)
    }
}
