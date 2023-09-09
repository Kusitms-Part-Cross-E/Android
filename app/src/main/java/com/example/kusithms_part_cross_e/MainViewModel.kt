package com.example.kusithms_part_cross_e

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kusithms_part_cross_e.RetrofitInstance.service
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val articleList = MutableLiveData<ArticleListResponse>()
    val article = MutableLiveData<ArticleResult>()
    fun getArticleList() {
        viewModelScope.launch {
            val response = service.getArticleList()
            articleList.postValue(response.body())
        }
    }

    fun getArticleDetail(articleId: Int) {
        viewModelScope.launch {
            val response = service.getArticleDetail(articleId)
            article.postValue(response.body())
        }
    }
}