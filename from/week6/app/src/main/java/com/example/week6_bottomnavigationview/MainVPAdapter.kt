package com.example.week6_bottomnavigationview

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainVPAdapter(fragmentActivity: Fragment): FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int = 3

    // 포지션에 따라서 어떤 fragment를 보여줄시
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> BbalgyeFragment()
            1 -> NeoguriFragment()
            2 -> WangFragment()
            else -> BbalgyeFragment()
        }
    }
}