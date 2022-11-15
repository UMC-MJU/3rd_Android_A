package com.example.umc_w6_mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_w6_mission.databinding.FragmentNotificationBinding
import com.google.android.material.tabs.TabLayoutMediator

class NotificationFragment : Fragment() {
    private lateinit var viewBinding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentNotificationBinding.inflate(layoutInflater)

        val notiVPAdapter = NotiVPAdapter(this)
        viewBinding.vpNotification.adapter = notiVPAdapter
        val tabTitleArray = arrayOf(
            "친구",
            "쪽지",
            "업무"
        )

        TabLayoutMediator(viewBinding.tabNotification, viewBinding.vpNotification) {
                tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        return viewBinding.root
//        return FragmentNotificationBinding.inflate(layoutInflater).root
    }
}