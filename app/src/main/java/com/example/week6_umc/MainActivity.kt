package com.example.week6_umc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_umc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 기본은 homeFragment
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, HomeFragment())
            .commitAllowingStateLoss()

        viewBinding.navigationBottom.run {
            setOnItemSelectedListener {
                when(it.itemId){ // 가장 고유한 값은 id 임.
                    R.id.menu_home ->{ // homeFragment로 이동
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting ->{ // settingFragment로 이동
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true // return boolean type
            }

            // 초기에 값을 세팅해준다. run 안 setOnItemSelected 밖에 포함이 되어 있다.
            selectedItemId = R.id.menu_home
        }
    }
}