package com.tamim.kotlinretrofitget.api

import com.tamim.kotlinretrofitget.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("posts/1")
    suspend fun getost() : Response<Post>
}