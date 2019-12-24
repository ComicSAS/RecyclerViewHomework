package com.example.recyclerviewhomework.presentation.activities.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.databinding.ActivityDetailBinding
import com.example.recyclerviewhomework.presentation.adapter.GalleryArrayAdapter
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

class Detail : AppCompatActivity() {

    lateinit var name: String
    lateinit var birthDate: String
    lateinit var description: String

    lateinit var galleryList: MutableList<Picture>

    lateinit var user: User

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
        user = intent.getParcelableExtra("user")
        name = user.name
        birthDate = user.birthDate
        description = user.description
        galleryList = user.gallery.gallery
        val binding: ActivityDetailBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.user = user
    }

    override fun onBackPressed() {
        when (val changedGallery = galleryArrayAdapter.getChangedGallery()) {
            galleryList -> {
                Log.d("myLogs", "Gallery is the same: ${changedGallery == galleryList}")
                setResult(Activity.RESULT_CANCELED)
            }
            else -> {
                user.gallery.gallery.clear()
                user.gallery.gallery.addAll(changedGallery)
                val intent = Intent().putExtra("changedUser", user)
                setResult(Activity.RESULT_OK, intent)
            }
        }
        finish()
    }
}
