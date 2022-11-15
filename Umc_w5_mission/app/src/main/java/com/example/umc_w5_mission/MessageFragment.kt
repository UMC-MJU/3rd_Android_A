package com.example.umc_w5_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc_w5_mission.databinding.FragmentMessageBinding
import com.example.umc_w5_mission.databinding.FragmentNotificationBinding
import com.example.umc_w5_mission.databinding.FragmentSettingBinding

class MessageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMessageBinding.inflate(layoutInflater).root
    }

}