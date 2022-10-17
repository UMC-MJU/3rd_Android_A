package com.example.week4_umc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week4_umc.databinding.ActivityMainBinding
import com.example.week4_umc.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        viewBinding.txtSecond.text= intent.getStringExtra("data")
    }
}