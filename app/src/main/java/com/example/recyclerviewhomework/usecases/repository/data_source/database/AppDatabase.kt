package com.example.recyclerviewhomework.usecases.repository.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.recyclerviewhomework.usecases.repository.data_source.database.dao.GalleryDao
import com.example.recyclerviewhomework.usecases.repository.data_source.database.dao.UserDao
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Gallery
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import com.example.recyclerviewhomework.usecases.repository.data_source.database.converter.Converters

@Database(entities = [(User::class), (Gallery::class), (Picture::class)], version = 3)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun galleryDao(): GalleryDao
}