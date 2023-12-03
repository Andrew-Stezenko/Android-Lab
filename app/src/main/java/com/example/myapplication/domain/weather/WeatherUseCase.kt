package com.example.myapplication.domain.weather

import com.example.myapplication.data.WeatherRepository

object WeatherUseCase {

    private val repo = WeatherRepository

    suspend fun getWeather(lat: String = "48.0", lon: String = "35.0"): String {

        val v = repo.getWeather(lat, lon)
        return v.toString()

//        val dataFromRepo: List<AnimalEntity> = AnimalUseCase.repo.getAnimalList()
//        val data = ArrayList<Animal>()
//        dataFromRepo.forEach {
//            data.add(AnimalUseCase.mapEntityToDomain(it))
//        }
//        delay(200)
//        return data
    }

//    fun mapEntityToDomain(data: AnimalEntity): Animal {
//        val data = Data(data.createData)
//        val dataStr = SimpleDateFormat("dd MMM yyyyy", Locale.getDefault()).format(data)
//        return Animal(
//            data.id,
//            data.name,
//            data.decs,
//        )
//    }
}