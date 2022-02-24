package com.tamim.kotlinretrofitget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tamim.kotlinretrofitget.repository.Repository

class MainActivity : AppCompatActivity() {

    private  lateinit var  viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  textView : TextView =findViewById(R.id.textviewDisplay);

        val repository=Repository()
        val viewModelFactory =MainViewModelFactory(repository)
        viewModel =ViewModelProvider(this,viewModelFactory).get(MainViewModel:: class.java)

       viewModel.getPost()
        viewModel.myResponse.observe(this , Observer {
            response ->
            if(response.isSuccessful){
                Log.d("response", response.body()?.myUserid.toString())
                Log.d("response", response.body()?.id.toString())
                Log.d("response", response.body()?.title!!)
                Log.d("response", response.body()?.body!!)
                textView.text=response.body()?.title!!
            }else{
                textView.text=response.errorBody().toString()

                Log.d("response", response.errorBody().toString())

            }
        })
    }
}