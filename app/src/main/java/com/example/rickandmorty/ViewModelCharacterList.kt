package com.example.rickandmorty

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModelCharacterList : ViewModel() {

    val liveData = MutableLiveData<List<Character>>()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val characterApi = retrofit.create(CharactersApi::class.java)

    init {
        getCharacters()
    }

    private fun getCharacters() {
        characterApi.getCharacters().enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                val json = response.body()
                val characters = json?.results
                if (characters != null) {
                    liveData.postValue(characters)
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}