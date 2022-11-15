package com.example.umc_w6_mission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_w6_mission.databinding.ItemImageBinding

class ItemRVAdapter (private val itemList: ArrayList<Item>): RecyclerView.Adapter<ItemRVAdapter.ItemViewHolder>() {
    // ViewHolder 객체
    inner class ItemViewHolder(private val viewBinding: ItemImageBinding): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item: Item) {
            viewBinding.itemIv.setImageResource(item.imageSrc)
        }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(viewBinding)
    }
    // ViewHolder가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
    // 표현할 Item 총 개수
    override fun getItemCount(): Int = itemList.size
}