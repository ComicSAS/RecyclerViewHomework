package com.example.recyclerviewhomework.di.module

import com.example.recyclerviewhomework.di.scope.RepositoryScope
import com.example.recyclerviewhomework.usecases.repository.AppRepository
import com.example.recyclerviewhomework.usecases.repository.data_source.database.AppDatabase
import com.example.recyclerviewhomework.usecases.repository.remote_data_source.communicator.ServerCommunicator
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @RepositoryScope
    internal fun provideRepository(communicator: ServerCommunicator, appDatabase: AppDatabase)
            : AppRepository = AppRepository(communicator, appDatabase)

}