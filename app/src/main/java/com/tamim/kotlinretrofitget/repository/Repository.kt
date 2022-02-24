package com.tamim.kotlinretrofitget.repository

import com.tamim.kotlinretrofitget.api.RetrofitInstance
import com.tamim.kotlinretrofitget.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost() : Response<Post>{
        return  RetrofitInstance.api.getost()
    }
}