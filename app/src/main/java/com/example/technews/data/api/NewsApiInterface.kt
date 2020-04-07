package com.example.technews.data.api

import com.example.technews.data.api.models.TopHeadlines
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiInterface {
    @GET("v2/everything")
    fun fetchTopTechHeadlines(
        @Query("category")
        sortBy: String = "business"
    ): Deferred<TopHeadlines>
}