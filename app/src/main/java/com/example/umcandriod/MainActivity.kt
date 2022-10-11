package com.example.umcandriod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umcandriod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     // 만들어지자마자 초기화 할 것임.
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater) // inflate : xml 해석을 할 것이다.
//        setContentView(R.layout.activity_main) // R은 우리앱의 모든 것을 관리를 함.
        setContentView(viewBinding.root) // xml 안에 있는 가장 위에 있는 layout을 불러온다.

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameFragment.id, FragmentFirst())
            .commitAllowingStateLoss()
        /* commitAllowingStateLoss
        * commit을 해주지만, state 가 날라가는 것을 허용함.
        * activity가 시작할 때, 상태를 복원하는 것이 있음.
        * 프로세스 이후에 commit을 하면 오류가 발생할 수 있어서 오류를 방지하기 위함
        * */

        viewBinding.btnFragment1.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, FragmentFirst())
                .commitAllowingStateLoss()
        }
        viewBinding.btnFragment2.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, FragmentSecond())
                .commitAllowingStateLoss()
        }
    }
}