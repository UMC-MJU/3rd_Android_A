package com.example.challenge_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.challenge_6.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)

        val mainVPAdapter = MainVPAdapter(this.requireActivity())
        viewBinding.vpMain.adapter = mainVPAdapter

        val tabTitleArray = arrayOf(
            "One",
            "Two",
            "Three",
        )

        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain) {tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        return viewBinding.root
    }
}
