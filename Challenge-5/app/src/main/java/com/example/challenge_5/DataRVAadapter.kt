package com.example.challenge_5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge_5.databinding.ItemDataBinding

class DataRVAadapter(private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAadapter.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: Data) {
            viewBinding.rvTitle.text = data.title
            viewBinding.rvDesc.text = data.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}