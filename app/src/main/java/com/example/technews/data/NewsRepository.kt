package com.example.technews.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.technews.data.api.NewsApiService
import com.example.technews.data.api.models.toArticleEntity
import com.example.technews.data.db.ArticleDao
import com.example.technews.data.db.ArticleEntity

class NewsRepository(
    private val articleDao: ArticleDao,
    private val apiService: NewsApiService
) {
    fun getCurrentArticleLive(): LiveData<List<ArticleEntity>> = articleDao.getArticles()

    suspend fun fetchArticles() {
        // fetch backend model from API
        val latestArticles = try {
            apiService.newsApi.fetchTopTechHeadlines().articles
        } catch (ex: Exception) {
            null
        }

        if (latestArticles == null) {
            Log.d("REPO", "Error fetching articles.")
        } else {
            Log.d("REPO", "Done fetching articles.")
        }

        // map to business logic models
        latestArticles?.map { it.toArticleEntity() }
            ?.also {
                // clear old articles
                articleDao.clearArticles()
                // save fresh article
                articleDao.saveArticles(it)
            }
    }
}