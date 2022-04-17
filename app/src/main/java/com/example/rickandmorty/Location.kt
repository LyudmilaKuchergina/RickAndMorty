package com.example.rickandmorty

import com.google.gson.annotations.SerializedName

data class Location (
    @SerializedName("name")
    val name: String
)
