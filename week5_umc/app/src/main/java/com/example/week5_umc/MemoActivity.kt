package com.example.week5_umc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5_umc.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    lateinit var binding: ActivityMemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapter(dataList)

        binding.memoRV.adapter = dataRVAdapter // adapter
        binding.memoRV.layoutManager = LinearLayoutManager(this)// layoutManager
        // context: 어플리케이션 정보가 들어가있음.

        // 데이터를 추가했을 때 recycler view 에 알려주어야 함.

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