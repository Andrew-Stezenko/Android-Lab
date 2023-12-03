package com.example.myapplication.data

import com.example.myapplication.data.local.AnimalDb
import com.example.myapplication.data.local.model.AnimalEntity
import com.example.myapplication.data.remote.AnimalApiInterface
import com.example.myapplication.data.remote.model.AnimalApi

object AnimalRepository {

    private val animalDb = AnimalDb()
    private val api = AnimalApiInterface()

    fun getAnimalList(): List<AnimalEntity> {
        val dataFromInet: List<AnimalApi>? = api.getAnimalList()
        if (dataFromInet != null) {
            val dataFromCache = ArrayList<AnimalEntity>()
            dataFromInet.forEach {
                dataFromCache.add(mapApiToEntity(it))
            }
            animalDb.saveAnimalList(dataFromCache)
            return animalDb.getAnimalList()
        } else {
            return animalDb.getAnimalList()
        }
    }

    private fun mapApiToEntity(apiData: AnimalApi): AnimalEntity {
        return AnimalEntity(
            System.currentTimeMillis(),
            apiData.externalId,
            apiData.animalName,
            apiData.decs,
            apiData.createData,
            null
        )

    }
}