package com.example.recyclerviewhomework.usecases.repository.data_source.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): MutableList<User>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getById(id: Int): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: MutableList<User>)

    @Query("DELETE FROM users")
    fun clearTable()
}