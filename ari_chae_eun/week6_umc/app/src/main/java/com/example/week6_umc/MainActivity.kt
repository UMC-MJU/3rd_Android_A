package com.example.week6_umc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_umc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        viewBinding.navigationBottom.run {
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_home ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_search ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, SearchFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }


            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.containerFragment.id, HomeFragment())
                .commitAllowingStateLoss()

            selectedItemId = R.id.menu_home
        }
    }
}