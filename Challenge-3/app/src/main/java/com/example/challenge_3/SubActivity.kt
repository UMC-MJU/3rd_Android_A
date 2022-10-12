package com.example.challenge_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challenge_3.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val extras = intent.extras
        val data = extras!!["key"] as String
        viewBinding.textView.text = data

        viewBinding.btnPrev.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", "back")
            startActivity(intent)
        }

        viewBinding.btnNext.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}