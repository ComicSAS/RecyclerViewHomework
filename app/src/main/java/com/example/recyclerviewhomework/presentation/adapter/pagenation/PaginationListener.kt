package com.example.recyclerviewhomework.presentation.adapter.pagenation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class PaginationListener(private val layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private var visibleItemCount = 0
    private var totalItemCount = 0
    private var firstVisibleItemPosition = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) {
            visibleItemCount = layoutManager.childCount
            totalItemCount = layoutManager.itemCount
            firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            if (visibleItemCount + firstVisibleItemPosition == totalItemCount) {
                recyclerView.stopScroll()
                loadMoreItems()
            }
        }
    }

    protected abstract fun loadMoreItems()
}

