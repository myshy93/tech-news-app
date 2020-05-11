package com.example.technews

import com.example.technews.data.db.ArticleEntity


class ArticleViewModel(dbArticle: ArticleEntity) {
    val source: String? = dbArticle.source.name
    val title: String? = dbArticle.title
    val brief: String? = dbArticle.description
    val imageUrl: String? = dbArticle.urlToImage
    val url: String? = dbArticle.url
}