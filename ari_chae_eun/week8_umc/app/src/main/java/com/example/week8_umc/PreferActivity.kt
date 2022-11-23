package com.example.week8_umc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week8_umc.databinding.ActivityPreferBinding

class PreferActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPreferBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapterForMemo(dataList)

        binding.memoRV.adapter = dataRVAdapter // adapter
        binding.memoRV.layoutManager = LinearLayoutManager(this)// layoutManager
    }
}