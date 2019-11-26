package com.example.recyclerviewhomework.domain

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import com.example.recyclerviewhomework.presentation.widget.SingleLiveEvent
import com.example.recyclerviewhomework.usecases.Interactor
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import io.reactivex.disposables.Disposable

class AllUserViewModel(app: Application, private val interactor: Interactor) : BaseAndroidViewModel(app) {

    private val liveDataItems = SingleLiveEvent<MutableList<User>>()

    @SuppressLint("CheckResult")
    fun getAllItems(): Disposable? =
            interactor.getAll()?.subscribe { list -> liveDataItems.value = list }


    fun getLiveDataItems(): LiveData<MutableList<User>> = liveDataItems

    fun clearUsersTable() {
        interactor.clearUsersTable()
    }

    override fun onCleared() {
        super.onCleared()

    }
}