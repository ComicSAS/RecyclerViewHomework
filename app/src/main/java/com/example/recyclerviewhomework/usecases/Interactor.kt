package com.example.recyclerviewhomework.usecases

import com.example.recyclerviewhomework.usecases.repository.AppRepository
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import io.reactivex.Single

class Interactor(private val repository: AppRepository) {

    fun getAll(): Single<MutableList<User>>? = repository.getAll()

    fun getUser(id: Int): Single<User> = repository.getUser(id)

    fun clearUsersTable(){
        repository.clearUsersTable()
    }
}