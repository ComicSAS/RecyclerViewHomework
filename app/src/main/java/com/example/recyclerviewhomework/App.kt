package com.example.recyclerviewhomework

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.recyclerviewhomework.di.component.*
import com.example.recyclerviewhomework.di.module.*
import com.example.recyclerviewhomework.usecases.repository.data_source.database.AppDatabase

class App : Application() {

    private var viewModelComponent: ViewModelComponent? = null
    private var dataBase: AppDatabase? = null

    init {
        applicationInstance = this
    }

    companion object {
        private lateinit var applicationInstance: App

        @JvmStatic
        fun getAppContext(): Context = applicationInstance.applicationContext

        fun get(): App = applicationInstance.applicationContext as App

        fun getContext(): Context = this.getContext()
    }

    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }

    private fun initRoom() {
        dataBase = Room.databaseBuilder(this, AppDatabase::class.java, "database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

    private fun initDagger() {
        val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        val apiComponent = DaggerApiComponent.builder()
                .appComponent(appComponent)
                .apiModule(ApiModule())
                .build()

        val databaseComponent = DaggerDataBaseComponent.builder()
                .databaseModule(DatabaseModule(this.dataBase!!))
                .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
                .apiComponent(apiComponent)
                .dataBaseComponent(databaseComponent)
                .repositoryModule(RepositoryModule())
                .build()

        val interactorComponent = DaggerInteractorComponent.builder()
                .repositoryComponent(repositoryComponent)
                .interactorModule(InteractorModule())
                .build()

        viewModelComponent = DaggerViewModelComponent.builder()
                .interactorComponent(interactorComponent)
                .viewModelModule(ViewModelModule(this))
                .build()
    }

    fun getViewModelComponent(): ViewModelComponent = this.viewModelComponent!!
}