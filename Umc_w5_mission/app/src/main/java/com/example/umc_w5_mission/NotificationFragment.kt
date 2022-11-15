package com.example.umc_w5_mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc_w5_mission.databinding.FragmentNotificationBinding

class NotificationFragment {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentNotificationBinding.inflate(layoutInflater).root
    }
}