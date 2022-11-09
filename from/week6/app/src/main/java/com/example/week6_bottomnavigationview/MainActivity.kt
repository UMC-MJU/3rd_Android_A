package com.example.week6_bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_bottomnavigationview.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 처음 화면 설정
        supportFragmentManager
            .beginTransaction()
            .replace(binding.containerFragment.id, HomeFragment())
            .commitAllowingStateLoss()

        // run(범위함수) 사용하면 navBottom 바로 쓸 수 있음
        binding.navBottom.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containerFragment.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_ramen -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.containerFragment.id, RamenFragment())
                            .commitAllowingStateLoss()


                    }
                }
                true
            }
            selectedItemId = R.id.menu_home // 초기에 설정한 것을 navBottom 에 알려주기 위해
        }
    }
}