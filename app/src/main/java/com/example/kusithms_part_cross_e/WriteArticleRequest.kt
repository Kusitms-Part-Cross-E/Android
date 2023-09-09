package com.example.kusithms_part_cross_e

data class WriteArticleRequest(
    val title : String,
    val description : String,
    val body : String,
    val tagList : List<String>
)
