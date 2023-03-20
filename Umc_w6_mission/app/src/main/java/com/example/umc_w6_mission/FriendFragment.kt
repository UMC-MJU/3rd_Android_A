package com.example.umc_w6_mission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umc_w6_mission.databinding.FragmentFriendBinding
import com.example.umc_w6_mission.databinding.FragmentHomeBinding

class FriendFragment : Fragment() {
    private lateinit var viewBinding: FragmentFriendBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFriendBinding.inflate(layoutInflater)
        return viewBinding.root
    }

}