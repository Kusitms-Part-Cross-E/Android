package com.example.kusithms_part_cross_e

data class ArticleListResponse(
    val isSuccess : Boolean,
    val message: String,
    val data : List<ArticleResult>
)

data class ArticleResult(
    val articleId: Int,
    val title: String,
    val description: String,
    val tagList: List<TagList>,
    val body: String,
    val createdAt: String,
    val updatedAt: String,
)

data class TagList(
    val tag : String
)
