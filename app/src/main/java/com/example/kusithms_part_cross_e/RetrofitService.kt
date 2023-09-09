package com.example.kusithms_part_cross_e

import retrofit2.http.GET

interface RetrofitService {
    @GET("/api/v1/articles")
    suspend fun getArticleList(): ArticleListResponse

}