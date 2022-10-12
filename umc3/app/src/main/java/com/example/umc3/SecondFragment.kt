package com.example.umc3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.umc3.databinding.FragmentFirstBinding
import com.example.umc3.databinding.FragmentSecondBinding

// fragment 상속 받음
class SecondFragment: Fragment() {
    private lateinit var viewBinding: FragmentSecondBinding
    // fragment는 onCreateView를 통해서 xml에 접근

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSecondBinding.inflate(inflater)
        // setContentView와 비슷한 역할
        return viewBinding.root
    }

}