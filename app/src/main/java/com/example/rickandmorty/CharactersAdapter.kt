package com.example.rickandmorty

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class CharactersAdapter(private val context: Context) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private var listCharacter: List<Character> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCharacter = listCharacter[position]
        holder.bind(itemCharacter, context)
    }

    override fun getItemCount(): Int = listCharacter.size

    //передаем данные и оповещаем адаптер о необходимости обновления списка
    fun refreshList(listCharacter: List<Character>) {
        this.listCharacter = listCharacter
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val tvSpecies = view.findViewById<TextView>(R.id.tvSpecies)
        private val tvGender = view.findViewById<TextView>(R.id.tvGender)
        private val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)

        fun bind(itemCharacter: Character, context: Context) {
            tvName.text = itemCharacter.name
            tvSpecies.text = itemCharacter.species
            tvGender.text = itemCharacter.gender
            ivAvatar.load(itemCharacter.image)
            itemView.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java).apply {
                    putExtra("id", itemCharacter.id)
                }
                context.startActivity(intent)
            }
        }
    }

}