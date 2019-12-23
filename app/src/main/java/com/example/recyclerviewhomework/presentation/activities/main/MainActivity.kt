package com.example.recyclerviewhomework.presentation.activities.main

import android.content.Intent
import android.os.Bundle
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

    private lateinit var userArrayAdapter: UserArrayAdapter

    private lateinit var layoutManager: LinearLayoutManager

    val onItemClick = object : IClickListener<User> {
        override fun onItemClick(model: User): Boolean {
//            intentDetail.putExtra("ID", model.id)
//            intentDetail.putExtra("name", model.name)
//            intentDetail.putExtra("description", model.description)
//            intentDetail.putExtra("birthDate", model.birthDate)
//            intentDetail.data = model.image
            intentDetail.putExtra("user", model)
            startActivity(intentDetail)
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
        viewModel?.getLiveDataItems()?.observe(this,
                androidx.lifecycle.Observer { loadData(it) })
    }

    private fun loadData(list: MutableList<User>) {
        userArrayAdapter.addItems(list)
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
}
