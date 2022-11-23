package com.example.week8_umc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week8_umc.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemoBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapterForMemo(dataList)

        val roomDB = AppDatabase.getInstance(this)
        if(roomDB != null){

            binding.memoRV.adapter = dataRVAdapter // adapter
            binding.memoRV.layoutManager = LinearLayoutManager(this)// layoutManager

            val postList = roomDB.postDao().selectAll();
            for(post1 in postList){
                dataList.add(Data(post1.title, post1.des))
            }
            dataRVAdapter.notifyItemInserted(dataRVAdapter.itemCount)

            getResultText = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()){result ->
                if(result.resultCode == RESULT_OK){
                    val title = result.data?.getStringExtra("title").toString()
                    val des = result.data?.getStringExtra("des").toString()
                    dataList.add(Data(title, des))
                    dataRVAdapter.notifyItemInserted(dataRVAdapter.itemCount)

                    val post = Post(title, des)
                    roomDB.postDao().insert(post)
                }
            }

            binding.memoAddBtn.setOnClickListener{
                val intent = Intent(this, MemoDesActivity::class.java)
                getResultText.launch(intent)
            }

        }
    }
}