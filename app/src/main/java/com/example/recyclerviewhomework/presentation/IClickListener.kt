package com.example.recyclerviewhomework.presentation

interface IClickListener<M> {

    fun onItemClick(model: M)
}