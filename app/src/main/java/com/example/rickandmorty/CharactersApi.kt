package com.example.rickandmorty

import retrofit2.Call
import retrofit2.http.GET

interface CharactersApi {
    @GET("api/character")
    fun getCharacters(): Call<Characters>
}