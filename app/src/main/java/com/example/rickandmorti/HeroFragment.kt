package com.example.rickandmorti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickandmorti.databinding.ActivityMainBinding
import com.example.rickandmorti.databinding.FragmentHeroBinding


class HeroFragment : Fragment() {

    private lateinit var binding: FragmentHeroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
    }

    private fun result() {

        val hero: Hero = arguments?.getSerializable("name") as Hero
        hero.image?.let { binding.imageView.setImageResource(it) }
        binding.textView.text = hero.text
        binding.tvTextView.text = hero.autor
    }

}