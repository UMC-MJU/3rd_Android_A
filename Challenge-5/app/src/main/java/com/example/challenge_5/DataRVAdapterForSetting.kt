package com.example.challenge_5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge_5.databinding.ItemSettingBinding

class DataRVAdapterForSetting(private val dataList: ArrayList<DataSetting>): RecyclerView.Adapter<DataRVAdapterForSetting.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemSettingBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: DataSetting) {
            viewBinding.rvSetting.text = data.settingMsg
            viewBinding.rvSwitch.isChecked = data.isOn

            viewBinding.rvSwitch.setOnClickListener{
                data.isOn = viewBinding.rvSwitch.isChecked
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemSettingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}