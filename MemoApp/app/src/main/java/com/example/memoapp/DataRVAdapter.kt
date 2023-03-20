package com.example.memoapp

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memoapp.databinding.ItemDataBinding

class DataRVAdapter(private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
    // ViewHolder 객체
    inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data: Data) {
            // textView
            viewBinding.tvContent.text = data.content
            // switch
            viewBinding.swcData.isChecked = data.isChecked
            viewBinding.swcData.setOnClickListener {
                data.isChecked = viewBinding.swcData.isChecked
                notifyItemChanged(adapterPosition)
            }
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
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
        holder.itemView.setOnLongClickListener {
            itemClickListener.onLongClick(it, position)
            return@setOnLongClickListener true
        }
    }
    // 표현할 Item 총 개수
    override fun getItemCount(): Int = dataList.size

    // RV Item ClickListener
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
        fun onLongClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    // RV Item 수정할 때 사용할 Position 저장해놓기
    private var selectedPosition: Int = 0
    fun getSelectedPosition(): Int {
        return selectedPosition
    }
    fun setSelectedPosition(position: Int) {
        selectedPosition = position
    }

}