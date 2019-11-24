package com.example.recyclerviewhomework.usecases.repository

import com.example.recyclerviewhomework.usecases.repository.data_source.database.AppDatabase
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import com.example.recyclerviewhomework.usecases.repository.remote_data_source.communicator.ServerCommunicator
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppRepository(private val serverCommunicator: ServerCommunicator, private val mainDatabase: AppDatabase) {
    fun getAll(): Single<MutableList<User>>? = serverCommunicator.getAllUsers()
            .flatMap { list ->
                mainDatabase.userDao().insertList(list)
                Single.just(mainDatabase.userDao().getAll())
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getUser(id: Int): Single<User> = serverCommunicator.getUser(id)
            .map {
                val user = mainDatabase.userDao().getById(id)
                user
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun clearDatabase() {
        mainDatabase.clearAllTables()
    }
}