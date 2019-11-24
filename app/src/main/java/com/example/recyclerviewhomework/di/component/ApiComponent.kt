package com.example.recyclerviewhomework.di.component

import com.example.recyclerviewhomework.di.module.ApiModule
import com.example.recyclerviewhomework.di.scope.ApiScope
import com.example.recyclerviewhomework.usecases.repository.remote_data_source.communicator.ServerCommunicator
import dagger.Component

@ApiScope
@Component(modules = [ApiModule::class], dependencies = [AppComponent::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}