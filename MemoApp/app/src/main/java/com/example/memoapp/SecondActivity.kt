package com.example.memoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.memoapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding
    private var memo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        if(intent.hasExtra("update_item"))
            memo = intent.getStringExtra("update_item").toString()
        viewBinding.editText.setText(memo)
    }

    override fun onResume() {
        super.onResume()

        viewBinding.btnBack.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("현재 내용이 저장되지 않았습니다.")
                .setMessage("뒤로 가시겠습니까?")
                .setPositiveButton("네") { dialog, which ->
                    // ThirdActivity로 보낼 intent 없으므로 RESULT_CANCELED 보내기
                    setResult(RESULT_CANCELED)
                    super.onBackPressed()
                }
                .setNegativeButton("아니오") { dialog, which -> }
                .create()
                .show()
        }
        viewBinding.btnNext.setOnClickListener {
            memo = viewBinding.editText.text.toString()
            // 수정
            if(intent.hasExtra("update_item")) {
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("save_item", memo)
                setResult(2, intent)
            }
            // 추가
            else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("add_item", memo)
                setResult(2, intent)
            }
            finish()
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