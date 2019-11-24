package com.example.recyclerviewhomework.di.module

import com.example.recyclerviewhomework.di.scope.InteractorScope
import com.example.recyclerviewhomework.usecases.Interactor
import com.example.recyclerviewhomework.usecases.repository.AppRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    @InteractorScope
    internal fun provideInteractor(appRepository: AppRepository) = Interactor(appRepository)
}