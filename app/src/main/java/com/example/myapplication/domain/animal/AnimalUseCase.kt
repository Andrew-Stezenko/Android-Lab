package com.example.myapplication.domain.animal

import com.example.myapplication.Animal
import com.example.myapplication.data.AnimalRepository
import com.example.myapplication.data.local.model.AnimalEntity
import kotlinx.coroutines.delay

object AnimalUseCase {

    private val repo = AnimalRepository

    suspend fun getAnimal(): List<Animal> {
        val dataFromRepo: List<AnimalEntity> = repo.getAnimalList()
        val data = ArrayList<Animal>()
//        dataFromRepo.forEach {
//            data.add(mapEntityToDomain(it))
//        }
        delay(200)
        return data
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