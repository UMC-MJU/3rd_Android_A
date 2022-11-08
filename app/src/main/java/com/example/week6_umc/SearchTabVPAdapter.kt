package com.example.week6_umc

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchTabVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    // 총 item 의 개수
    override fun getItemCount(): Int = 3

    // 어떤 fragment를 보여줄 것인지?
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> SearchOneFragment()
            1 -> SearchTwoFragment()
            2 -> SearchThreeFragment()
            else -> OneFragment()
        }
    }
}