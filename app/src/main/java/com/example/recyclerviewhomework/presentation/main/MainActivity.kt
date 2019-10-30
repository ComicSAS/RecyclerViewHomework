package com.example.recyclerviewhomework.presentation.main

import android.net.Uri
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.adapter.UserArrayAdapter
import com.example.recyclerviewhomework.model.User
import com.example.recyclerviewhomework.pagenation.PaginationListener

import java.util.ArrayList

import com.example.recyclerviewhomework.model.DataClass.dateOfBirthArray
import com.example.recyclerviewhomework.model.DataClass.imageArray
import com.example.recyclerviewhomework.model.DataClass.nameArray

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    internal var userList = ArrayList<User>()

    internal var names = nameArray
    internal var birthDates = dateOfBirthArray
    internal var images = imageArray

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
        val userArrayAdapter = UserArrayAdapter()
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
