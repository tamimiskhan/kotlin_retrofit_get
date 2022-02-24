package com.tamim.kotlinretrofitget.model

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("userId")
    val myUserid : Int,
    val id: String,
    val title: String,
    val body: String

)