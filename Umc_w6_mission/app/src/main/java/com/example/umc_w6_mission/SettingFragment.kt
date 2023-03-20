package com.example.umc_w6_mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_w6_mission.databinding.FragmentFriendBinding
import com.example.umc_w6_mission.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var viewBinding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSettingBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}