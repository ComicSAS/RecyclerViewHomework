package com.example.recyclerviewhomework.presentation.adapter.pagenation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationListener protected constructor(private val layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0
    private var firstVisibleItemPosition: Int = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) {
            visibleItemCount = layoutManager.childCount
            totalItemCount = layoutManager.itemCount
            firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
                loadMoreItems()
            }
        }
    }

    protected abstract fun loadMoreItems()
}

