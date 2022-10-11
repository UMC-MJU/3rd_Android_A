package com.example.umcandriod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umcandriod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.mainBtn.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", viewBinding.mainText.text.toString())
            startActivity(intent)
        }
    }

}