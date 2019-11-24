package com.example.recyclerviewhomework.di.module

import com.example.recyclerviewhomework.usecases.repository.data_source.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val appDataBase: AppDatabase) {

    @Provides
    internal fun provideAppDatabase(): AppDatabase = appDataBase
}