package com.example.memoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.memoapp.MainActivity.Companion.memo
import com.example.memoapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.textView.text = memo

        viewBinding.btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }

}