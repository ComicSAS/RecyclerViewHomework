package com.example.recyclerviewhomework.di.component

import com.example.recyclerviewhomework.di.module.DatabaseModule
import com.example.recyclerviewhomework.usecases.repository.data_source.database.AppDatabase
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DataBaseComponent {
    val database: AppDatabase
}