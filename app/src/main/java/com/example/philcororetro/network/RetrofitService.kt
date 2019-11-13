package com.example.philcororetro.network

import com.example.philcororetro.model.Action
import com.example.philcororetro.model.ActionsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("actions")
    suspend fun getActions(): ActionsResponse
}