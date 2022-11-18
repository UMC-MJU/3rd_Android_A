package com.example.umc_w6_mission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_w6_mission.databinding.ItemImageBinding

class ItemRVAdapter (private val itemList: ArrayList<Item>): RecyclerView.Adapter<ItemRVAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(private val viewBinding: ItemImageBinding): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item: Item) {
            viewBinding.itemIv.setImageResource(item.imageSrc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewBinding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(viewBinding)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
    override fun getItemCount(): Int = itemList.size
}