package com.example.umcandriod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.umcandriod.R
import com.example.umcandriod.UIPractice.CallActivity

class EveryTimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_every_time)
    }

    fun onButtonClick(v: View?) {
        val intent = Intent(this, CallActivity::class.java)
        startActivity(intent)
    }
}