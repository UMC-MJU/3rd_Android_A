package com.example.challenge_5

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_5.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    private lateinit var viewBinding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val dataList: ArrayList<String> = arrayListOf()
        val dataRVAdapterForMemo = DataRVAdapterForMemo(dataList)

        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
//                dataList.add()
                dataList.add(0, result.data?.getStringExtra("contents").toString())
                dataRVAdapterForMemo.notifyItemInserted(0)
            }
        }
        viewBinding.btnAdd.setOnClickListener {
            val intent = Intent(
                this, AddMemoActivity::class.java)
            getResultText.launch(intent)
        }

        dataList.apply {
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")

            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")

            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")

            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
            add("메모입니다.")
        }

        viewBinding.rvData.adapter = dataRVAdapterForMemo
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        viewBinding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

}