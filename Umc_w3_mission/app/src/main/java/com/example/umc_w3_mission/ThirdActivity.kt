package com.example.umc_w3_mission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_w3_mission.databinding.ActivityMainBinding
import com.example.umc_w3_mission.databinding.ActivitySecondBinding
import com.example.umc_w3_mission.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameLayout.id, FirstFragment())
            .commitAllowingStateLoss()

        viewBinding.btnFragment1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameLayout.id, FirstFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.btnFragment2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameLayout.id, SecondFragment())
                .commitAllowingStateLoss()
        }
    }
}