package com.example.kusithms_part_cross_e

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kusithms_part_cross_e.RetrofitInstance.service
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val articleList = MutableLiveData<ArticleListResponse>()

    fun getArticleList() {
        viewModelScope.launch {
            val response = service.getArticleList()
            articleList.postValue(response.body())
        }
    }
}