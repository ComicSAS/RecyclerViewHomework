package com.example.recyclerviewhomework.presentation.activities.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.di.component.ViewModelComponent
import com.example.recyclerviewhomework.domain.AllUserViewModel
import com.example.recyclerviewhomework.presentation.activities.detail.Detail
import com.example.recyclerviewhomework.presentation.adapter.UserArrayAdapter
import com.example.recyclerviewhomework.presentation.adapter.pagenation.PaginationListener
import com.example.recyclerviewhomework.presentation.base.BaseActivity
import com.example.recyclerviewhomework.presentation.item.IClickListener
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    var viewModel: AllUserViewModel? = null
        @Inject set

    lateinit var intentDetail: Intent

    lateinit var user: User

    private lateinit var userArrayAdapter: UserArrayAdapter

    private lateinit var layoutManager: LinearLayoutManager

    val onItemClick = object : IClickListener<User> {
        override fun onItemClick(model: User): Boolean {
            intentDetail.putExtra("user", model)
            startActivityForResult(intentDetail, RC_DETAIL)
            return true
        }

    }

    override fun injectDependency(component: ViewModelComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()

        item_list.addOnScrollListener(object : PaginationListener(layoutManager) {
            override fun loadMoreItems() {
                viewModel?.getAllItems()
            }
        })
    }

    private fun initViewModel() {
        viewModel?.clearUsersTable()
        viewModel?.getAllItems()
        viewModel?.getLiveDataItems()?.observe(this, Observer { loadData(it) })
    }

    private fun loadData(list: MutableList<User>) {
        userArrayAdapter.addItems(list)
    }

    private fun loadUpdatedUser(user: User) {
        userArrayAdapter.updateItem(user)
    }

    private fun initRecyclerView() {
        intentDetail = Intent(this, Detail::class.java)
        userArrayAdapter = UserArrayAdapter(onItemClick)
        // use a linear layout manager
        layoutManager = LinearLayoutManager(this)
        item_list.layoutManager = layoutManager
        item_list.itemAnimator = DefaultItemAnimator()
        item_list.adapter = userArrayAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            resultCode == Activity.RESULT_CANCELED -> return
            resultCode == Activity.RESULT_OK && requestCode == RC_DETAIL -> {
                user = data!!.getParcelableExtra("changedUser")
                Log.d("myLogs", "Main: userGallery size: ${user.gallery.gallery.size}")
                viewModel?.updateUser(user)
                Log.d("myLogs", "Main: userId: ${user.id}")
                viewModel?.getUserById(user.id)
                viewModel?.getLiveDataItem()?.observe(this, Observer { loadUpdatedUser(it) })
            }
        }
    }

    companion object {
        const val RC_DETAIL = 0
    }
}
