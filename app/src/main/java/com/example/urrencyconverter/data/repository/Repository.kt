package com.example.urrencyconverter.data.repository

import com.example.urrencyconverter.data.api.RetrofitInstance
import com.example.urrencyconverter.model.nal.AllJsonData
import retrofit2.Response

class Repository {
    suspend fun  getValut() : Response<AllJsonData>
    {
        return RetrofitInstance.api.getMoneys()
    }
}