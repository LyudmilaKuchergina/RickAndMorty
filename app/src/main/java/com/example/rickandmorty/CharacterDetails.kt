package com.example.rickandmorty

import com.google.gson.annotations.SerializedName

data class CharacterDetails (
    @SerializedName( "ID")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("location")
    val location: Location,

    @SerializedName( "episode")
    val episode: List<String>

)
