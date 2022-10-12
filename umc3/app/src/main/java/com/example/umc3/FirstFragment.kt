package com.example.umc3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.umc3.databinding.FragmentFirstBinding

// fragment 상속 받음
class FirstFragment: Fragment() {
    private lateinit var viewBinding: FragmentFirstBinding
    // fragment는 onCreateView를 통해서 xml에 접근

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFirstBinding.inflate(inflater)
        // setContentView와 비슷한 역할
        return viewBinding.root
    }

}