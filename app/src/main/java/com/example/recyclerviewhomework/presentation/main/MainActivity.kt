package com.example.recyclerviewhomework.presentation.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.adapter.UserArrayAdapter
import com.example.recyclerviewhomework.model.DataClass.dateOfBirthArray
import com.example.recyclerviewhomework.model.DataClass.imageArray
import com.example.recyclerviewhomework.model.DataClass.nameArray
import com.example.recyclerviewhomework.model.User
import com.example.recyclerviewhomework.pagenation.PaginationListener
import com.example.recyclerviewhomework.presentation.IClickListener
import com.example.recyclerviewhomework.presentation.detail.Detail
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var intentDetail: Intent

    lateinit var recyclerView: RecyclerView

    internal var userList = ArrayList<User>()

    internal var names = nameArray
    internal var birthDates = dateOfBirthArray
    internal var images = imageArray

    val onItemClick = object : IClickListener<User> {
        override fun onItemClick(model: User) {
            intentDetail.putExtra("name", model.name)
            intentDetail.putExtra("description", model.description)
            intentDetail.putExtra("birthDate", model.birthDate)
            intentDetail.data = model.image
            startActivity(intentDetail)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initData() {
        // Populating list items
        for (i in 0..24) {
            val name = names[i]
            val dateOfBirth = birthDates[i]
            val uri = Uri.parse(images[i])
            userList.add(User(name, dateOfBirth,
                    "Description " + "\nCool Person"
                            + "\nGreat Guy!", uri))
        }
    }

    protected fun initRecyclerView() {
        intentDetail = Intent(this, Detail::class.java)
        val userArrayAdapter = UserArrayAdapter(onItemClick)
        recyclerView = findViewById(R.id.item_list)
        // use a linear layout manager
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = userArrayAdapter
        initData()
        userArrayAdapter.addItems(userList)

        recyclerView.addOnScrollListener(object : PaginationListener(layoutManager) {
            override fun loadMoreItems() {
                userArrayAdapter.addItems(userList)
            }
        })
    }
}