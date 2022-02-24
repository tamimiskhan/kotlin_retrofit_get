package com.tamim.kotlinretrofitget

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamim.kotlinretrofitget.model.Post
import com.tamim.kotlinretrofitget.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private  val reposotory : Repository): ViewModel(){

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response : Response<Post> =reposotory.getPost()
            myResponse.value=response
        }
    }
}