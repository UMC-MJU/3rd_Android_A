package com.example.umc_w5_mission

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class NotiVPAdapter(fragmentActivity: NotificationFragment): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FriendFragment()
            1 -> MessageFragment()
            2 -> WorkFragment()
            else -> FriendFragment()
        }
    }

}