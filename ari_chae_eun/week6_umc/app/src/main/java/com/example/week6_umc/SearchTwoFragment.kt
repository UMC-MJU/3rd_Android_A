package com.example.week6_umc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week6_umc.databinding.FragmentSearchTwoBinding


class SearchTwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentSearchTwoBinding.inflate(layoutInflater).root
    }
}