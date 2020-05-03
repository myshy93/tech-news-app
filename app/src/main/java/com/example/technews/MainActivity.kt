package com.example.technews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technews.data.NewsRepository
import com.example.technews.data.db.ArticleEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ArticlesAdapter
    private val repository: NewsRepository by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            repository.fetchArticles()
        }

        // Create the observer which updates the UI.
        val articleObserver = Observer<List<ArticleEntity>> { articleList ->
            setView(articleList)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        repository.getCurrentArticleLive().observe(this, articleObserver)

    }


    fun setView(articles: List<ArticleEntity>) {
        linearLayoutManager = LinearLayoutManager(this)
        adapter = ArticlesAdapter()
        articles.map { it ->
            ArticleViewModel(it)
        }.also {
            adapter.setArticles(it)
        }
        recyclerView.adapter = adapter
    }

}

