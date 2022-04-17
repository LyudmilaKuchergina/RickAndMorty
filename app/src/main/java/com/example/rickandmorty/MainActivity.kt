package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var model: ViewModelCharacterList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProvider(this).get(ViewModelCharacterList::class.java)

        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.hasFixedSize()

        rcView.layoutManager = LinearLayoutManager(this)
        val adapter = CharactersAdapter(this)
        rcView.adapter = adapter

        model.liveData.observe(this, {
            adapter.refreshList(it)
        })
    }
}