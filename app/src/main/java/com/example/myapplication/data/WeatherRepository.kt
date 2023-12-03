package com.example.myapplication.data

import com.example.myapplication.data.remote.ApiFactory
import com.example.myapplication.data.remote.model.WeatherApiModel

object WeatherRepository {

    private val api = ApiFactory.weatherApi
//    private val API_KEY = "7d31fa3d928db13433eed3fa0aef859a"

    suspend fun getWeather(lat: String = "48.8", lon: String = "38.0"): WeatherApiModel? {
        val params = HashMap<String, String>()
        params.put("lat", lat)
        params.put("lon", lon)
        params.put("appid", lon)
        params.put("units", "metric")
        params.put("exclude", "minutely")

        val dataFromInet = api.getWeather(params)
        if (dataFromInet.isSuccessful && dataFromInet.body() != null) {
            return dataFromInet.body()
        } else return null


//        val resp = safetyCall {api.getWeather(params)}
//
//        return when (resp) {
//            is Result.Success -> resp.data
//            else -> null
//        }
    }

//    private suspend fun <T> safetyCall(call: suspend () -> Response<T>): Result<T> {
//        val response: Result<T>
//        try {
//            val result = call.invoke()
//            response = if (result.isSuccessful){
//                Result.Success(result.body()!!)
//            } else {
//                Result.Error(result.code(), result.toString())
//            }
//            return response
//        } catch (e: Exception) {
//            return when (e) {
//                is SocketTimeoutException -> Result.ErrorTimeOut
//                is UnknownHostException -> Result.ErrorUnknown
//
//                else -> Result.ErrorUnknown
//            }
//        }
//    }
}