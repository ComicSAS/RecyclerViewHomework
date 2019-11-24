package com.example.recyclerviewhomework.usecases.repository.remote_data_source.communicator

import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import io.reactivex.Single

interface ApiService {
    fun getUsers(): Single<List<User>>

    fun getUserById(id: Int): Single<User>
}