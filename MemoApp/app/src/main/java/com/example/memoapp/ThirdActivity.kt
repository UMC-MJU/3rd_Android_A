package com.example.memoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.memoapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityThirdBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // intent 구분
        if(intent.hasExtra("update_item"))
            viewBinding.textView.text = intent.getStringExtra("update_item")

        // SecondActivity Result를 받기 위해 Callback 등록
        getResultText = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == 2) {
                val intent = result.data
//                Log.d("수정할 아이템 인텐트", "${intent!!.hasExtra("save_item")}")
                viewBinding.textView.text = intent!!.getStringExtra("save_item")
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewBinding.textView.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("update_item", viewBinding.textView.text)
            getResultText.launch(intent)
        }

        viewBinding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("completed_item", viewBinding.textView.text)
            setResult(3, intent)
            finish()
        }
    }

}