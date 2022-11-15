package com.example.umc_w5_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc_w5_mission.databinding.FragmentFriendBinding
import com.example.umc_w5_mission.databinding.FragmentSettingBinding

class FriendFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFriendBinding.inflate(layoutInflater).root
    }

}