package com.example.myapplication.data.remote.model

import com.google.gson.annotations.SerializedName

data class WeatherApiModel(
    val lat: Float?,
    val lon: Float?,
    val timezone: String?,
    val linkToImage: String?,
    @SerializedName("timezone_offset") val timezoneOffset: Long?,
    val current: String?,
    val hourly: String?,
    val daily: String?,
)
