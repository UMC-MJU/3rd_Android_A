package com.example.challenge_5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge_5.databinding.ActivityAddMemoBinding

class AddMemoActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAddMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAddMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener {
            val intent = Intent( this, MemoActivity::class.java).apply {
                putExtra("contents", viewBinding.editText.text.toString())
            }
            setResult(RESULT_OK, intent)
            if (!isFinishing) finish()
        }



    }
}