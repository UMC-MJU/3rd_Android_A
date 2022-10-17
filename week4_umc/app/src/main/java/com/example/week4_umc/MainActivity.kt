package com.example.week4_umc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week4_umc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater) // 메모리에 올려준다.
        val view = viewBinding.root
        setContentView(view)

        viewBinding.btnMain.setOnClickListener{
            var intent = Intent(this, SecondActivity::class.java)
            // 명시적 인텐트, 클래스 명을 사용해서 정확하게 intent 해줬기 때문에
            intent.putExtra("data", viewBinding.editMain.text.toString())
            startActivity(intent)
        }
    }
}