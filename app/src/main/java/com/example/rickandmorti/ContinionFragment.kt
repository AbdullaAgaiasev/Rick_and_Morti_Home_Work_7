package com.example.rickandmorti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rickandmorti.databinding.ActivityMainBinding
import com.example.rickandmorti.databinding.FragmentContinionBinding

class ContinionFragment : Fragment() {
lateinit var adapter: HeroAdapter
var list = arrayListOf<Hero>()
    private lateinit var binding: FragmentContinionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContinionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {

        adapter = HeroAdapter(list,this::onClick)
        binding.recyclerView.adapter = adapter

        list.add(Hero("Rick","Morti",R.drawable.img))
        list.add(Hero("Rick","Morti",R.drawable.img_1))
        list.add(Hero("Rick","Morti",R.drawable.img_2))
        list.add(Hero("Rick","Morti",R.drawable.img_3))
        list.add(Hero("Rick","Morti",R.drawable.img))
        list.add(Hero("Rick","Morti",R.drawable.img))
        list.add(Hero("Rick","Morti",R.drawable.img))
        list.add(Hero("Rick","Morti",R.drawable.img))
    }

    private fun onClick(hero: Hero) {
        val bundle = Bundle()
        bundle.putSerializable("name",hero)
        findNavController().navigate(R.id.heroFragment,bundle)
    }

}