package com.example.technews.data.api

import com.example.technews.data.api.models.TopHeadlines
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiInterface {
    @GET("v2/top-headlines")
    suspend fun fetchTopTechHeadlines(
        @Query("category")
        category: String = "technology",
        @Query("country")
        country: String = "ro"
    ): TopHeadlines
}