package com.example.week6_umc

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week6_umc.databinding.ActivityMainBinding
import com.example.week6_umc.databinding.FragmentHomeBinding
import com.example.week6_umc.databinding.FragmentSearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchFragment : Fragment() {

    private lateinit var viewBinding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSearchBinding.inflate(layoutInflater)

        val searchAdapter = SearchTabVPAdapter(this)
        viewBinding.vpMain.adapter = searchAdapter // vp main 에는 adapter를 사용할 예정이다.

        val tabTitleArray = arrayOf(
            "Search 1",
            "Search 2",
            "Search 3"
        )

        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain){ tab, position -> // parameter 작성,
            // tab: 직접 받은 tab 의미, position : tab의 위치
            tab.text = tabTitleArray[position]
        }.attach() // attach는 연결을 최종적으로 하겠다.

        return viewBinding.root
    }
}