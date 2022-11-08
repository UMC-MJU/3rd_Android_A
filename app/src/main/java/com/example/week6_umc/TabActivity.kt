package com.example.week6_umc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_umc.databinding.ActivityTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity() {

    private val viewBinding:ActivityTabBinding by lazy{
        ActivityTabBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val tabVPAdapter = TabVPAdapter(this)
        viewBinding.vpMain.adapter = tabVPAdapter // vp main 에는 dapter를 사용할 예정이다.

        val tabTitleArray = arrayOf(
            "One",
            "Two"
        )

        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain){ tab, position -> // parameter 작성,
            // tab: 직접 받은 tab 의미, position : tab의 위치
            tab.text = tabTitleArray[position]
        }.attach() // attach는 연결을 최종적으로 하겠다.
    }
}