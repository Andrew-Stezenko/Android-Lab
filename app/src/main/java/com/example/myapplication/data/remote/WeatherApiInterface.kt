package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.model.WeatherApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherApiInterface {

    @GET("/facts/random?animal_type=cat&amount=1")
    suspend fun getWeather(@QueryMap params: Map<String, String>): Response<WeatherApiModel>
}