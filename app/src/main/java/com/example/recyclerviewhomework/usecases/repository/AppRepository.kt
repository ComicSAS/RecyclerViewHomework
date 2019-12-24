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

    fun getUserbyId(id: Int): Single<User> = Single.just(mainDatabase.userDao().getUserById(id))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun clearUsersTable() {
        mainDatabase.userDao().clearTable()
    }

    fun updateUser(user: User) {
        mainDatabase.userDao().updateUser(user)
    }

}