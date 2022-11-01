package com.example.week5_umc
 
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.week5_umc.databinding.ActivityListViewBinding

class CustomAdapter(context: Context, private val businessCardArrayList: ArrayList<BusinessCard>):BaseAdapter(){

    // 시스템에 있는 api를 호출해서 앱과 os 사이의 중재자 역할을 한다.
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding:ActivityListViewBinding

    // arrayList 사이즈 반환
    override fun getCount(): Int = businessCardArrayList.size

    override fun getItem(p0: Int): Any = businessCardArrayList[p0]

    override fun getItemId(p0: Int): Long  = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        binding = ActivityListViewBinding.inflate(inflater, p2, false)

        // 위치에 맞는 데이터를 세팅
        // 스크롤이 되거나 최초 시점에 순서에 맞게 데이터를 넣어준다.
        binding.nameListviewItem.text = businessCardArrayList[p0].name
        binding.contentsListviewItem.text = businessCardArrayList[p0].contents

        return binding.root
    }
}