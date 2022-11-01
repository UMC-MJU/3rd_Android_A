package com.example.week5_umc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week5_umc.databinding.ActivityListViewBinding
import com.example.week5_umc.databinding.ActivityMainBinding

data class BusinessCard(val name:String, val contents: String)

class MainActivity : AppCompatActivity() {

    var businessCardArrayList = ArrayList<BusinessCard>()

    // 어댑터 작성한 것을 ListView에 세팅해줘야 함.
    private lateinit var customAdapter:CustomAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        for(x in 0..30){
            businessCardArrayList.add(BusinessCard("록", "하이"))
            businessCardArrayList.add(BusinessCard("담", "하이"))
            businessCardArrayList.add(BusinessCard("록", "하이"))
            businessCardArrayList.add(BusinessCard("담", "하이"))
        }

        
        customAdapter = CustomAdapter(this, businessCardArrayList)
        // 리스트 뷰에 어댑터 넣어주기
        binding.listView.adapter = customAdapter

    }
}