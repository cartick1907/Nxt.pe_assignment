package com.example.nxtpeassignment.repository

import com.example.nxtpeassignment.api.NxtPeAPI
import com.example.nxtpeassignment.models.PageItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class mandateRepository @Inject constructor(private val nxtPeApi:NxtPeAPI) {

    private val _pageData = MutableStateFlow<List<PageItem>>(emptyList())
    val pageData: StateFlow<List<PageItem>>
        get()=_pageData
    suspend fun getData(){
        val response = nxtPeApi.getPageData()
        _pageData.emit(response.page_items)

    }
}