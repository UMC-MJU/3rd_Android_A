package com.example.week8_umc

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week8_umc.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    lateinit var binding: ActivityMemoBinding
    lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapterForMemo(dataList)



        binding.memoRV.adapter = dataRVAdapter // adapter
        binding.memoRV.layoutManager = LinearLayoutManager(this)// layoutManager

        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){result ->
            if(result.resultCode == RESULT_OK){
                dataList.add(Data(result.data?.getStringExtra("title").toString(), result.data?.getStringExtra("des").toString()))
                dataRVAdapter.notifyItemInserted(dataRVAdapter.itemCount)
            }
        }

        binding.memoAddBtn.setOnClickListener{
            val intent = Intent(this, MemoDesActivity::class.java)
            getResultText.launch(intent)
        }
    }
}