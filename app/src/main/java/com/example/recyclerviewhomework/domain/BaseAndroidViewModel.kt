package com.example.recyclerviewhomework.domain

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import com.example.recyclerviewhomework.App

abstract class BaseAndroidViewModel(app: Application) : AndroidViewModel(app) {
    fun getContext() = getApplication<App>()
    fun getString(@StringRes id: Int): String = getContext().getString(id)
}