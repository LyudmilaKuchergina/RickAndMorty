package com.example.rickandmorty

import com.google.gson.annotations.SerializedName

data class Characters (
    @SerializedName( "results")
    val results: List<Character>
)