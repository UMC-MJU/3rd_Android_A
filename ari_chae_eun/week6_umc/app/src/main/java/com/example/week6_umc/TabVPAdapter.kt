package com.example.week6_umc

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabVPAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // 총 item 의 개수
    override fun getItemCount(): Int = 2

    // 어떤 fragment를 보여줄 것인지?
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> OneFragment()
            1 -> TwoFragment()
            else -> OneFragment()
        }
    }


}