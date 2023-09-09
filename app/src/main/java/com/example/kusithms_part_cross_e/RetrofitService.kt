package com.example.kusithms_part_cross_e

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService {
    @GET("/api/v1/articles")
    suspend fun getArticleList(): Response<ArticleListResponse>

    @POST("/api/v1/articles")
    fun writeArticle(@Body parameters: WriteArticleRequest): Call<WriteArticleResponse>
    @GET("/api/v1/articles/{articleId}")
    suspend fun getArticleDetail(
        @Path("articleId") articleId: Int
    ): Response<ArticleResult>

}