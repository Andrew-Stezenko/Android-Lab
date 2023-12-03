package com.example.myapplication.data.local.model

data class AnimalEntity(
    val id: Long,
    val exeternalId: String,
    val name: String,
    val decs: String,
    val createData: Long,
    val picture: Int?,
) {

}
