package com.example.memoapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memoapp.databinding.ActivityMainBinding

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
            add(Data("해야 할 일", false))
            add(Data("살 것", false))
            add(Data("으아아아 힘들다", false))
            add(Data("안드로이드 공부 꾸준히 하기", false))
            add(Data("갓생 살자^^", false))
            add(Data("오", false))
            add(Data("아이언맨 보고싶다잉", false))
            add(Data("삼겹살 먹고싶다", false))
            add(Data("바닐라라떼 버블티", false))
            add(Data("o_<", false))
            add(Data("ABCDEFG", false))
            add(Data("1", false))
            add(Data("2", false))
            add(Data("3", false))
            add(Data("4", false))
            add(Data("5", false))
            add(Data("6", false))
            add(Data("7", false))
        }
        val dataRVAdapter = DataRVAdapter(dataList)
        viewBinding.rvData.adapter = dataRVAdapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        dataRVAdapter.setItemClickListener( object : DataRVAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                dataRVAdapter.setSelectedPosition(position)
//                Log.d("setPosition: ","${dataRVAdapter.getSelectedPosition()}")
                val intent = Intent(viewBinding.root.context, ThirdActivity::class.java)
                intent.putExtra("update_item", dataList[position].content)
                getResultText.launch(intent)
            }
            @RequiresApi(Build.VERSION_CODES.P)
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
                // resultCode: ToActivity(여기선 MainActivity)로 intent를 보내는 "FromActiviy Number"로 설정
                // requestCode/resultCode로 구분해 다수의 Activity Result 처리 가능
                if (result.resultCode == 3) {
                    // 수정
//                    Log.d("getPosition: ","${dataRVAdapter.getSelectedPosition()}")
                    val intent = result.data
                    val memo = intent!!.getStringExtra("completed_item")
                    dataList[dataRVAdapter.getSelectedPosition()].content = memo.toString()
                    dataRVAdapter.notifyItemChanged(dataRVAdapter.getSelectedPosition())
                }
                else if(result.resultCode == 2) {
                    // 추가
                    val intent = result.data
                    val memo = intent!!.getStringExtra("add_item")
                    dataList.add(Data(memo.toString(), false))
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