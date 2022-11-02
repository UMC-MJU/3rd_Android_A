package com.example.memoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.memoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    companion object { // 전역변수로 만들어서 intent로 전달하지 않아도 됨
        var memo : String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    override fun onResume() {
        super.onResume()

        viewBinding.btnNext.setOnClickListener {
            memo = viewBinding.editText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        memo = viewBinding.editText.text.toString()
        viewBinding.editText.text.clear()
    }

    override fun onRestart() {
        super.onRestart()

        AlertDialog.Builder(this)
            .setMessage("이어서 작성하시겠습니까?")
            .setPositiveButton("네"
            ) { dialog, which -> viewBinding.editText.setText(memo) }
            .setNegativeButton("아니오"
            ) { dialog, which ->
                viewBinding.editText.text.clear()
                memo = ""
            }
            .create()
            .show()
    }
}