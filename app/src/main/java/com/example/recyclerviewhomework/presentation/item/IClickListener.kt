package com.example.recyclerviewhomework.presentation.item

interface IClickListener<M> {

    fun onItemClick(model: M):Boolean
}