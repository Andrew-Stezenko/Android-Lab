package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.weather.WeatherUseCase
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {
//    lateinit var viewModel: FirstViewModel
//
//    override fun onCreateView(): View {
//        viewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
//    }

    //    private val animalUseCase = AnimalUseCase
    private val weatherUseCase = WeatherUseCase

    val animalListLd = MutableLiveData<List<Animal>>()
    val weatherLd = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getAllData()
    }

    fun getAllData() {
        viewModelScope.launch {
            isLoading.postValue(true)

//            val animalList = animalUseCase.getAnimal()
//            animalListLd.postValue(animalList)

            val data = weatherUseCase.getWeather()
            weatherLd.postValue(data)

            isLoading.postValue(false)
        }
    }
}