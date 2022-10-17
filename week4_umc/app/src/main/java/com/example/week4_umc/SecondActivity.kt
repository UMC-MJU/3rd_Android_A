package com.example.week4_umc

import android.content.Intent
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

        viewBinding.secondBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java);
            intent.putExtra("data", viewBinding.editText.text.toString())
            startActivity(intent)
        }
    }
}