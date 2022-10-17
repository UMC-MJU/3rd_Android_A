package com.example.umcandriod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umcandriod.databinding.ActivityMainBinding
import com.example.umcandriod.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        // 넘어온 정보를 받는다
        val intentExtras = intent.extras
        val data = intentExtras!!["text"] as String // 형변환(as) !!(not null인 것이 확실할 때)
        viewBinding.tvSecondText.text = data

        viewBinding.secondBtn.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btnBack.setOnClickListener{
            val intent = Intent(this@SecondActivity, MainActivity::class.java)
            intent.putExtra("test", "Back")
            setResult(RESULT_OK, intent)
            finish() // 이전 액티비티를 종료하고자 하는 경우
        }

    }
}