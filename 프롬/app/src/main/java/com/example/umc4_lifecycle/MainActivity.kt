package com.example.umc4_lifecycle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc4_lifecycle.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnMain.setOnClickListener {

            var intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("data",binding.edtMain.text.toString() )
            startActivity(intent)
        }

        val dataList: ArrayList<Data> = arrayListOf()

        dataList.apply {
            add(Data("hello","1"))
            add(Data("hello","2"))
            add(Data("hello","3"))
            add(Data("hello","4"))
            add(Data("hello","5"))
            add(Data("hello","6"))
            add(Data("hello","7"))
            add(Data("hello","8"))
            add(Data("hello","9"))
            add(Data("hello","10"))
            add(Data("hello","11"))
            add(Data("hello","12"))
            add(Data("hello","13"))



        }
        val dataRVAdapter = DataRVAdapter(dataList)

        binding.recyclerView.adapter = dataRVAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }




}