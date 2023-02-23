package com.example.urrencyconverter.data.api

import com.example.urrencyconverter.model.nal.AllJsonData
import com.example.urrencyconverter.model.nal.New

import retrofit2.Response
import retrofit2.http.GET



interface ApiService {

    @GET("daily_json.js")
    suspend fun getMoneys() : Response<AllJsonData>
}