package com.example.umc_w6_mission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_w6_mission.databinding.FragmentHomeBinding
import me.relex.circleindicator.CircleIndicator2


class HomeFragment : Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)
        val itemList: ArrayList<Item> = arrayListOf()
        itemList.apply {
            add(Item(R.drawable.image_1))
            add(Item(R.drawable.image_2))
            add(Item(R.drawable.image_3))
            add(Item(R.drawable.image_4))
            add(Item(R.drawable.image_5))
            add(Item(R.drawable.image_6))
        }
        val itemRVAdapter = ItemRVAdapter(itemList)
        viewBinding.rvItem.adapter = itemRVAdapter
        viewBinding.rvItem.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(viewBinding.rvItem)
        val indicator: CircleIndicator2 = viewBinding.indicator
        indicator.attachToRecyclerView(viewBinding.rvItem, pagerSnapHelper)

        return viewBinding.root
    }

}