package com.example.umc_w6_mission

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_w6_mission.databinding.FragmentHomeBinding
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding
    private val itemList: ArrayList<Item> = arrayListOf()

    var currentPage = 0
    val handlerThread: HandlerThread by lazy {
        HandlerThread("viewPager auto slide")
    }
    private lateinit var autoslide:PagerRunnable
    inner class PagerRunnable:Thread() {
        override fun run() {
            // 처음부터 전후 스크롤이 가능하게 하기 위해 절반부터 시작
            currentPage = Int.MAX_VALUE / 2 - kotlin.math.ceil(itemList.size.toDouble() / 2).toInt()
            viewBinding.vpHome.setCurrentItem(currentPage,false)
            currentPage+=1

            while(handlerThread.isAlive){
                while(true) {
                    Handler(handlerThread.looper).post{
                        setPage()
                    }
                    sleep(2000)
                }
            }
        }
    }
    private fun setPage() {
        viewBinding.vpHome.setCurrentItem(currentPage,true)
        currentPage+=1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemList.apply {
            add(Item(R.drawable.image_1))
            add(Item(R.drawable.image_2))
            add(Item(R.drawable.image_3))
            add(Item(R.drawable.image_4))
            add(Item(R.drawable.image_5))
            add(Item(R.drawable.image_6))
        }
        val homeVPAdapter = HomeVPAdapter(itemList)
        val viewPager = viewBinding.vpHome
        viewPager.adapter = homeVPAdapter

        // indicator 개수가 무한스크롤을 위해 생성된 item 개수만큼 생성되는 문제
        // 아래와 같이 하면 indicator가 itemList size만큼 생성은 되지만 selected는 되지 않음
        // => CircleIndicator3를 상속받은 customView를 만들어서 layout xml에 사용
        homeVPAdapter.changeItemCountListSize()
        viewBinding.indicator.setViewPager(viewPager)
        homeVPAdapter.changeItemCountIntMAX()

        handlerThread.start()
        autoslide = PagerRunnable()
        autoslide?.start()
    }

}