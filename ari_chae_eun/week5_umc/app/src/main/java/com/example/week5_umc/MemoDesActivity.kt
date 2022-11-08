package com.example.week5_umc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week5_umc.databinding.ActivityMemoBinding
import com.example.week5_umc.databinding.ActivityMemoDesBinding

class MemoDesActivity : AppCompatActivity() {
    lateinit var binding: ActivityMemoDesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoDesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createBtn.setOnClickListener{
            val intent = Intent(this, MemoActivity::class.java)
            intent.putExtra("title", binding.editTitle.text.toString())
            intent.putExtra("des", binding.editDes.text.toString())
            setResult(RESULT_OK, intent)

            if(!isFinishing) finish()
        }
    }
}