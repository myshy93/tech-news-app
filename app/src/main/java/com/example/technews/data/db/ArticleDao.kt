package com.example.technews.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    suspend fun getArticles(): List<ArticleEntity>

    @Insert
    suspend fun saveArticles(list: List<ArticleEntity>)

    @Query("DELETE FROM articles")
    suspend fun clearArticles()
}