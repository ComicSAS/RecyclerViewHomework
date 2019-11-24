package com.example.recyclerviewhomework.di.module

import com.example.recyclerviewhomework.di.scope.ApiScope
import com.example.recyclerviewhomework.usecases.repository.remote_data_source.communicator.ServerCommunicator
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    @ApiScope
    fun provideCommunicator(): ServerCommunicator = ServerCommunicator()
}