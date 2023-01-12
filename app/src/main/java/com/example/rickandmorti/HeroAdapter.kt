package com.example.rickandmorti

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorti.databinding.ItemHeroBinding

class HeroAdapter(private val list: ArrayList<Hero>, private val onItemClick: (Hero) -> Unit) :
    RecyclerView.Adapter<HeroAdapter.SongViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class SongViewHolder(private val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(music: Hero) = with(binding) {
            text.text=music.text
            autor.text = music.autor
            music.image?.let { ivImage.setImageResource(it) }
            itemView.setOnClickListener {
                onItemClick.invoke(music)
            }
        }
    }
}