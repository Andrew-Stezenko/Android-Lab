package com.example.myapplication.data

import com.example.myapplication.data.remote.ApiFactory
import com.example.myapplication.data.remote.model.WeatherApiModel

object WeatherRepository {
    private val api = ApiFactory.weatherApi
    private val API_KEY = "7d31fa3d928db13433eed3fa0aef859a"

    suspend fun getWeather(lat: String = "48.8", lon: String = "38.0"): WeatherApiModel? {
        val params = HashMap<String, String>()
        params.put("lat", lat)
        params.put("lon", lon)
        params.put("appid", API_KEY)
        params.put("units", "metric")
        params.put("exclude", "minutely")

        val dataFromInet = api.getWeather(params)
        if (dataFromInet.isSuccessful && dataFromInet.body() != null) {
            return dataFromInet.body()
        } else return null
    }
}