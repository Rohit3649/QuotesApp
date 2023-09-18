package com.example.notesapp.repository.remote.api

import com.example.notesapp.models.QuotesItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface QuotesAPI {

    @GET("v3/b/6508892f167bf4300b76697b?meta=false")
    suspend fun getQuotes(@Header("X-JSON-Path") category: String) : Response<List<QuotesItem>>

    @GET("v3/b/6508892f167bf4300b76697b?meta=false")
    @Headers("X-JSON-Path: quotes..category")
    suspend fun getCategories() : Response<List<String>>
}