package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(val name: String, val author: String, val year: String, val country: String) :
    Parcelable {

    init {
        name
        author
        year
        country
    }
}
