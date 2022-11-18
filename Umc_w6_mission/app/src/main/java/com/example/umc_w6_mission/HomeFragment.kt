package com.example.umc_w6_mission

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_w6_mission.databinding.FragmentHomeBinding
import me.relex.circleindicator.CircleIndicator2
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding

    var currentPage = 0
    val handlerThread: HandlerThread by lazy {
        HandlerThread("viewPager auto slide")
    }
    private lateinit var autoslide:PagerRunnable
    inner class PagerRunnable:Thread() {
        override fun run() {
//            while(handlerThread.isAlive){
            while(true) {
                if(viewBinding.vpHome.currentItem+1 == viewBinding.vpHome.adapter?.itemCount) {
                    handlerThread.quitSafely()
                    break
                    // 마지막까지 가면 다시 처음으로 돌아가기
//                    viewBinding.vpHome.setCurrentItem(0, true)
                }
                Handler(handlerThread.looper).post{
                    setPage()
                }
                sleep(2000)
//            }
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
        val viewPager = viewBinding.vpHome
        viewPager.adapter = itemRVAdapter
        viewBinding.indicator.setViewPager(viewPager)

        // 다른 데로 갔다가 다시 돌아올 때 그 보고 있던 페이지가 유지되었으면 좋겠음
        // 스레드가 멈춰있는 것보다는 그 포지션을 저장해놔야 하나?
        handlerThread.start()
        autoslide = PagerRunnable()
        autoslide?.start()
    }

    override fun onStart() {
        super.onStart()

        // 저장된 포지션부터 페이지 슬라이드 다시 시작

    }

    override fun onStop() {
        super.onStop()
//        handlerThread.quitSafely()
    }
}