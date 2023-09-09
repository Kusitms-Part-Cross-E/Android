package com.example.kusithms_part_cross_e

data class WriteArticleResponse(
    val isSuccess : Boolean,
    val message: String,
    val data : NewArticle
)

data class NewArticle(
    val articleId: Int,
    val title : String,
    val description : String,
    val body : String,
    val tagList : List<String>,
    val createdAt : String,
    val updatedAt : String
)
