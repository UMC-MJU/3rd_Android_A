package com.example.memoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        // RecyclerView에 item 사이에 divider(구분선) 추가
        val rv = viewBinding.rvData
        val divider = DividerItemDecoration(this, viewBinding.layoutMemolist.orientation)
        rv.addItemDecoration(divider)

        val dataList: ArrayList<Data> = arrayListOf()
        dataList.apply {
            add(Data("일"))
            add(Data("이"))
            add(Data("삼"))
            add(Data("사"))
            add(Data("오ㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ"))
            add(Data("육"))
            add(Data("칠"))
            add(Data("팔8938498493"))
            add(Data("일"))
            add(Data("이"))
            add(Data("삼"))
            add(Data("사"))
            add(Data("오ㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ"))
            add(Data("육"))
            add(Data("칠"))
            add(Data("팔8938498493"))
            add(Data("일"))
            add(Data("이"))
            add(Data("삼"))
            add(Data("사"))
            add(Data("오ㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ"))
            add(Data("육"))
            add(Data("칠"))
            add(Data("팔8938498493"))
        }
        val dataRVAdapter = DataRVAdapter(dataList)
        viewBinding.rvData.adapter = dataRVAdapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        dataRVAdapter.setItemClickListener( object : DataRVAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                dataRVAdapter.setSelectedPosition(position)
                val intent = Intent(viewBinding.root.context, ThirdActivity::class.java)
                intent.putExtra("update_item", dataList[position].content)
                getResultText.launch(intent)
            }
            override fun onLongClick(view: View, position: Int) {
                AlertDialog.Builder(viewBinding.root.context)
                    .setMessage("삭제하시겠습니까?")
                    .setPositiveButton("네") { dialog, which ->
                        dataList.removeAt(position)
                        dataRVAdapter.notifyItemRemoved(position)
                        dataRVAdapter.notifyItemRangeRemoved(position, dataRVAdapter.itemCount-position)
                        // notifyItemRangeRemoved() 안 하면 position은 업데이트 되지 않아서 뒤로 밀리면서 꼬임
                    }
                    .setNegativeButton("아니오") { dialog, which -> }
                    .create()
                    .show()
            }
        })
        getResultText = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) { result ->
                // resultCode: ToActivity(여기선 MainActivity)로 intent를 보내는 FromActiviy Number
                // requestCode/resultCode로 Activity Result 처리
                if (result.resultCode == 3) {
                    // 수정
                    val intent = result.data
                    val memo = intent!!.getStringExtra("completed_item")
                    dataList.set(dataRVAdapter.getSelectedPosition(), Data(memo.toString()))
                    dataRVAdapter.notifyItemChanged(dataRVAdapter.getSelectedPosition())
                }
                else if(result.resultCode == 2) {
                    // 추가
                    val intent = result.data
                    val memo = intent!!.getStringExtra("add_item")
                    dataList.add(Data(memo.toString()))
                    dataRVAdapter.notifyItemInserted(dataRVAdapter.itemCount)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewBinding.btnAdd.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            getResultText.launch(intent)
        }
    }
}