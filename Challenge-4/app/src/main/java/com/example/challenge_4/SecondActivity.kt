package com.example.challenge_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge_4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.txt2.text = intent.getStringExtra("data")
    }
}