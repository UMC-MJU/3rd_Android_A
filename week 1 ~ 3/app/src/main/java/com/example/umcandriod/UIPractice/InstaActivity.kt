package com.example.umcandriod.UIPractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.umcandriod.R

class InstaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta)
    }
    fun onButtonClick(v: View?) {
        val intent = Intent(this, ClassPicActivity::class.java)
        startActivity(intent)
    }
}