package com.example.challenge_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.challenge_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val msg = intent.getStringExtra("key")
        if(!TextUtils.isEmpty(msg)) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        viewBinding.btnNext.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("key", viewBinding.editText.text.toString())
            startActivity(intent)
        }
    }
}