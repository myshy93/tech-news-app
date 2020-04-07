package com.example.technews.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArticleEntity::class, SourceEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao?

    companion object {
        const val DATABASE_NAME: String = "news.db"
    }
}