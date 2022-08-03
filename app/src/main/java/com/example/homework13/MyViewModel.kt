package com.example.homework13

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    init{
        getInfo()
    }
    private fun getInfo(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.service().getInfo()


            if(response.isSuccessful){
                val body = response.body()
                d("info", body.toString())
            }else{
                val errorBody = response.errorBody()
            }}     catch (e: java.lang.Exception){


                d("info", e.toString())
            }
        }
    }


}