package com.example.challenge_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAadapter = DataRVAadapter(dataList)

        dataList.apply {
            add(Data("hello", "1"))
            add(Data("hello", "2"))
            add(Data("hello", "3"))
            add(Data("hello", "4"))
            add(Data("hello", "5"))
            add(Data("hello", "6"))
            add(Data("hello", "7"))
            add(Data("hello", "8"))
            add(Data("hello", "9"))
            add(Data("hello", "10"))
            add(Data("hello", "11"))
            add(Data("hello", "12"))
            add(Data("hello", "13"))
            add(Data("hello", "14"))
            add(Data("hello", "15"))
            add(Data("hello", "16"))
            add(Data("hello", "17"))
            add(Data("hello", "18"))
            add(Data("hello", "19"))
            add(Data("hello", "20"))
        }

        viewBinding.rvData.adapter = dataRVAadapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        viewBinding.btnSetting.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnFragment1.setOnClickListener {
            val intent = Intent(this, MemoActivity::class.java)
            startActivity(intent)
        }

    }

}