package com.example.newsapp.data.network

import android.util.Size
import com.example.newsapp.data.model.NewsResponse
import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/everything")
    fun getCommonMuslimNews(
        @Query("q") q: String = "islam",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 10,
        @Query("sortBy") sortBy: String = "popularity"
    ) : Call<NewsResponse>

    @GET("/v2/everything")
    fun getAlQuranNews(
        @Query("q") q: String = "Free Palestine",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>


    @GET("/v2/everything")
    fun getAlJazeeraNews(
        @Query("q") q: String = "Islamic History",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>


    @GET("/v2/everything")
    fun getWarningForMuslimNews(
        @Query("q") q: String = "islamophobia",
        @Query("language") language: String = "en"
    ): Call<NewsResponse>


    @GET("/v2/everything")
    fun getSearchNews(
        @Query("q") q: String,
        @Query("pageSize") pageSize: Int = 19,
    ): Call<NewsResponse>
}