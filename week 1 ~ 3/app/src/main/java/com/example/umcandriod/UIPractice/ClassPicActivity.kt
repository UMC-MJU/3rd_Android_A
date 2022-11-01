package com.example.umcandriod.UIPractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.umcandriod.EveryTimeActivity
import com.example.umcandriod.R

class ClassPicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_pic)
    }

    fun onButtonClick(v: View?) {
        val intent = Intent(this, EveryTimeActivity::class.java)
        startActivity(intent)
    }
}