package com.example.nxtpeassignment.api

import com.example.nxtpeassignment.models.PageData
import com.example.nxtpeassignment.models.PageItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface NxtPeAPI {

    @GET("mandate/res.json")
    suspend fun getPageData() : PageData


}