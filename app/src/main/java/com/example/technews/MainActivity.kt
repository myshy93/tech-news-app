package com.example.technews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technews.data.ArticlesAdapter
import com.example.technews.data.models.Article
import com.example.technews.data.models.Source
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ArticlesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = ArticlesAdapter()
        val item = Article(
            "Mihai",
            "Test",
            "Test descr",
            "20.03.2020",
            Source("1", "stirioficiale.ro"),
            "Test news",
            "http://stirioficiale.ro",
            "https://www.chip.de/ii/1/2/6/2/4/2/7/9/2/0ff1c473c636f193.jpeg"
        )
        adapter.setArticles(listOf(item))
        recyclerView.adapter = adapter
    }
}
