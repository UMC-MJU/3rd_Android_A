package com.example.umcandriod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.umcandriod.databinding.ActivitySecondBinding
import com.example.umcandriod.databinding.FragmentFirstBinding

class FragmentFirst : Fragment() {
    private lateinit var viewBinding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { // 무조건 return 값을 전달하기 때문에 View?일 필요가 없어서 ?를 지운다.
        viewBinding = FragmentFirstBinding.inflate(layoutInflater)
        return viewBinding.root // setContentView 비슷하다고 생각을 하면 됨
    }

}