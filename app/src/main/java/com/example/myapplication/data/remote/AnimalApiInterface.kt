package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.model.AnimalApi

class AnimalApiInterface {
    fun getAnimalList(): List<AnimalApi>? {
        if (System.currentTimeMillis() % 2 == 0L) {
            return generateAnimalList()
        } else {
            return null
        }
    }

    private fun generateAnimalList(): List<AnimalApi> {
        return listOf(
//            AnimalApi("hjclsdbf")
        )
    }

//    private fun AnimalApi(animalName: String): AnimalApi {
//
//    }
}