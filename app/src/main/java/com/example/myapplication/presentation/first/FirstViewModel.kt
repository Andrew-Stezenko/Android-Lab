package com.example.myapplication.presentation.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.WeatherUseCase
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {

    private val weatherUseCase = WeatherUseCase

    val weatherLd = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getAllData()
    }

    fun getAllData() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val data = weatherUseCase.getWeather()
            weatherLd.postValue(data)

            isLoading.postValue(false)
        }
    }
}