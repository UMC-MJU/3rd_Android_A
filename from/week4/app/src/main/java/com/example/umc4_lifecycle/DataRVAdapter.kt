package com.example.umc4_lifecycle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc4_lifecycle.databinding.ItemDataBinding

class DataRVAdapter(private  val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
//    private  val dataList: ArrayList<Data> = arrayListOf()

    // ViewHolder 객체체
   inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root) {
    fun bind(data: Data) {
        viewBinding.title.text = data.title
        viewBinding.description.text = data.desc
    }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
       val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    // ViewHolder가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    // 표현할 Item의 총 개수
    override fun getItemCount(): Int = dataList.size
}