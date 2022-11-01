package com.example.week5_umc

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5_umc.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    lateinit var binding: ActivityMemoBinding
    lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapter(dataList)

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




//        Handler(mainLooper).postDelayed({
//            dataList.apply {
//                add(Data("hello", "7"))
//                add(Data("hello", "8"))
//                add(Data("hello", "9"))
//                add(Data("hello", "10"))
//            }
////            dataRVAdapter.notifyDataSetChanged() // 데이터 셋이 추가 되었음.
//            // dataSetChanged()를 사용하지 않는 이유는 기존에 있는 recycler view 의 정보들을 모두 다 가져와야 한다. 완전히 새로고침할 때 사용한다.
//            dataRVAdapter.notifyItemRangeInserted(11, 1)
//
//        }, 1000)
    }
}