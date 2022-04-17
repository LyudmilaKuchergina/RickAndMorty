package com.example.rickandmorty

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {
    @GET("api/character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): Call<CharacterDetails>
}