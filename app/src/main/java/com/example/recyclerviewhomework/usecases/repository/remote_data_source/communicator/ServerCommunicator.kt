package com.example.recyclerviewhomework.usecases.repository.remote_data_source.communicator

import android.net.Uri
import android.util.Log
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Gallery
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.model.DataClass
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ServerCommunicator {
    //(private val mService: ApiService)

    companion object {
        private val DEFAULT_TIMEOUT = 10
        private val DEFAULT_RETRY_ATTEMPTS = 4L

        private val names = DataClass.nameArray
        private val birthDates = DataClass.dateOfBirthArray
        private val images = DataClass.imageArray
    }


    fun getAllUsers(): Single<MutableList<User>> = getUsers()
            .compose(singleTransformer())
            .doOnError { t: Throwable -> Log.d("ServerCommunicator", t.message) }

    fun getUser(id: Int): Single<User> = getUserById(id).compose(singleTransformer())


    private fun <T> singleTransformer(): SingleTransformer<T, T> = SingleTransformer {
        it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .retry(DEFAULT_RETRY_ATTEMPTS)
    }

    fun getUsers(): Single<MutableList<User>> = Single.just(initData())


    fun getUserById(id: Int): Single<User> = Single.just(initData()[id])

    fun initData(): MutableList<User> {
        val galleryList = mutableListOf<Picture>()
        for (i in 0..12) {
            val url = images[i]
            galleryList.add(Picture(0, url))
        }

        val userList = mutableListOf<User>()
        // Populating list items
        for (i in 0..24) {
            val name = names[i]
            val dateOfBirth = birthDates[i]
            val url = images[i]
            userList.add(User(0, name, dateOfBirth,
                    "Description " + "\nCool Person"
                            + "\nGreat Guy!", url, Gallery(0, galleryList)))
        }
        return userList
    }
}