package com.example.myapplication.data.local

import com.example.myapplication.data.local.model.AnimalEntity

class AnimalDb {

    fun getAnimalList(): List<AnimalEntity> {
        return listOf(
            AnimalEntity(
                1,
                "kfdjgn",
                "kndjfg",
                "Jack jhsdfbu",
                System.currentTimeMillis(),
                null
            ),
            AnimalEntity(2, "kfdjng", "kfnsdj", "fsdjkn", System.currentTimeMillis(), null),
            AnimalEntity(
                2,
                "k345dfgsfegg",
                "fnsdjkhgkljb",
                "ffhaL;SG",
                System.currentTimeMillis(),
                null
            ),
        )
    }

    fun saveAnimalList(list: List<AnimalEntity>) {
        //kljnfsdknjlfgdnjk
    }
}