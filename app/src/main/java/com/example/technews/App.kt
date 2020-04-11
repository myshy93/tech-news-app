package com.example.technews

import android.app.Application
import androidx.room.Room
import com.example.technews.data.NewsRepository
import com.example.technews.data.api.NewsApiService
import com.example.technews.data.db.NewsDatabase
import com.example.technews.data.db.NewsDatabase.Companion.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize dependency injection
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }

    // Module containing all project dependencies
    private val appModule = module {
        single { Room.databaseBuilder(get(), NewsDatabase::class.java, DATABASE_NAME).build() }
        single { get<NewsDatabase>().articleDao() }
        single { NewsApiService() }
        single { NewsRepository(get(), get()) }
    }
}