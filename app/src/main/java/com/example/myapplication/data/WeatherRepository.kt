package com.example.myapplication.data

import com.example.myapplication.data.remote.ApiFactory
import com.example.myapplication.data.remote.model.WeatherApiModel

object WeatherRepository {

    private val api = ApiFactory.weatherApi

    suspend fun getWeather(lat: String = "48.8", lon: String = "38.0"): WeatherApiModel? {
        val params = HashMap<String, String>()
        params.put("lat", lat)
        params.put("lon", lon)
        params.put("units", "metric")
        params.put("exclude", "minutely")

        val dataFromInet = api.getWeather(params)
        if (dataFromInet.isSuccessful && dataFromInet.body() != null) {
            return dataFromInet.body()
        } else return null
    }
}