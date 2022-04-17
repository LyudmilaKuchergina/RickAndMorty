package com.example.rickandmorty

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModelCharacterDetails : ViewModel() {

    val liveData = MutableLiveData<CharacterDetails>()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val characterApi = retrofit.create(CharacterApi::class.java)

    fun getCharacter(id: Int) {
        characterApi.getCharacter(id).enqueue(object : Callback<CharacterDetails> {
            override fun onResponse(
                call: Call<CharacterDetails>,
                response: Response<CharacterDetails>
            ) {
                val characterDetails = response.body()
                liveData.postValue(characterDetails)
            }

            override fun onFailure(call: Call<CharacterDetails>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}