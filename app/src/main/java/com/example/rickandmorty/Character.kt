package com.example.rickandmorty

import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName( "id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("image")
    val image: String
)
