package com.example.week6_bottomnavigationview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6_bottomnavigationview.databinding.ActivityMainBinding
import com.example.week6_bottomnavigationview.databinding.FragmentRamenBinding
import com.google.android.material.tabs.TabLayoutMediator

class RamenFragment:Fragment() {
    private lateinit var binding: FragmentRamenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedINstanceState: Bundle?
    ): View {
        binding = FragmentRamenBinding.inflate(layoutInflater)

        val mainVPAdapter = MainVPAdapter(this)
        binding.vpRamen.adapter = mainVPAdapter
        val tabTitleArray = arrayOf(
            "틈새라면",
            "너구리라면",
            "왕뚜껑",
        )

        TabLayoutMediator(binding.tabRamen, binding.vpRamen){tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
        return binding.root
    }
}