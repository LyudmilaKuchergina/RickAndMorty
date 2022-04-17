package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.rickandmorty.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    lateinit var model: ViewModelCharacterDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("id",1)
        model = ViewModelProvider(this).get(ViewModelCharacterDetails::class.java)
        model.liveData.observe(this, {
            binding.tvdName.text = it.name
            binding.tvdSpecies.text = it.species
            binding.tvdGender.text = it.gender
            binding.tvdStatus.text = it.status
            binding.tvdEpisode.text = it.episode.size.toString()
            binding.imdAvatar.load(it.image)
            binding.tvdLocation.text = it.location.name
        })
        model.getCharacter(id)
    }
}

