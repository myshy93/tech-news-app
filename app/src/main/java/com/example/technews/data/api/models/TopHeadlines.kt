package com.example.technews.data.api.models


import com.google.gson.annotations.SerializedName

data class TopHeadlines(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)