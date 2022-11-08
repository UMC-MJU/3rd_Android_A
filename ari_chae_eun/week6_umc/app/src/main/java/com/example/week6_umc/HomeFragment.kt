package com.example.week6_umc

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week6_umc.databinding.ActivityMainBinding
import com.example.week6_umc.databinding.ActivityTabBinding
import com.example.week6_umc.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // this 대신 getActivity 사용
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)

        viewBinding.mainToTabBtn.setOnClickListener{
            val intent = Intent(getActivity(), TabActivity::class.java)
            startActivity(intent)
        }

        return viewBinding.root
    }
}