package com.example.challenge_5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge_5.databinding.ItemMemoBinding
import com.example.challenge_5.databinding.ItemSettingBinding

class DataRVAdapterForMemo(private val dataList: ArrayList<String>): RecyclerView.Adapter<DataRVAdapterForMemo.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemMemoBinding): RecyclerView.ViewHolder(viewBinding.root) {
        val view = viewBinding
        fun bind(data: String) {
            viewBinding.rvMemo.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.view.rvItem.setOnClickListener {
            dataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = dataList.size
}