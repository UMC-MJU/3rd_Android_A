package com.example.umc4_lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc4_lifecycle.databinding.ActivityMainBinding
import com.example.umc4_lifecycle.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtSecond.text = intent.getStringExtra("data")
    }


}