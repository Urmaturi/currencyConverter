package com.example.urrencyconverter.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.urrencyconverter.data.repository.Repository
import com.example.urrencyconverter.model.nal.AllJsonData
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel: ViewModel() {
    var repo = Repository()
    val valytList : MutableLiveData<Response<AllJsonData>> =MutableLiveData()

    fun getMoney()
    {
        viewModelScope.launch {
            valytList.value =    repo.getValut()
        }
    }



}