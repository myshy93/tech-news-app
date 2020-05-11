package com.example.technews.data.api.models


import com.example.technews.data.db.ArticleEntity
import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("content")
    val content: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("publishedAt")
    val publishedAt: String? = "",
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("urlToImage")
    val urlToImage: String? = ""
)

fun Article.toArticleEntity(): ArticleEntity =
    ArticleEntity(
        id = null,
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        source = source.toSourceEntity(),
        title = title,
        url = url,
        urlToImage = urlToImage
    )
