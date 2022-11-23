package com.example.week8_umc

import android.content.Intent
import android.os.Bundle
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
        val roomDB = AppDatabase.getInstance(this)
        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapterForMemo(dataList, roomDB)


        if(roomDB != null){

            binding.memoRV.adapter = dataRVAdapter // adapter
            binding.memoRV.layoutManager = LinearLayoutManager(this)// layoutManager

            val postList = roomDB.postDao().selectAll();
            for(post1 in postList){
                dataList.add(Data(post1.title, post1.des, post1.postId))
            }
            dataRVAdapter.notifyItemInserted(dataRVAdapter.itemCount)

            getResultText = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()){result ->
                if(result.resultCode == RESULT_OK){
                    val title = result.data?.getStringExtra("title").toString()
                    val des = result.data?.getStringExtra("des").toString()
                    val post = Post(title, des)
                    dataList.add(Data(title, des, post.postId))
                    dataRVAdapter.notifyItemInserted(dataRVAdapter.itemCount)

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