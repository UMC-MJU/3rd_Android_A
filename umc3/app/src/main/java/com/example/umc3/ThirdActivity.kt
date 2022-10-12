package com.example.umc3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc3.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)


        setContentView(viewBinding.root)
        // 무조건 manifest에 등록을 해야되는데 이게 애초에 Activity로 만들면 manifest에 자동으로 등록됨
        // Activity로 생성하지 않았을 시 manifest에 어떠한 Activity를 사용할거라고 적어줘야함

//        // main에서 putExtra로 정보를 넣었기 때문에 extras에 그 정보가 담겨있음
        val extras = intent.extras
        // !! 느낌표는 name 의 value가 무조건 null이 아니다. 내가 개발자니까 장담한다 이런 의미임
        val data = extras!!["text3"] as String // 강제 형변환
        viewBinding.thirdTx.text = data

//
        viewBinding.thirdTx.setOnClickListener {


            supportFragmentManager
                .beginTransaction() // 시작하겠다
                .replace(viewBinding.frameFragment3.id,FirstFragment())
                .commitAllowingStateLoss() // commit을 해주는데 state가 날라가는 것을 허용
                // activity가 시작할 때 오류 방지.

            viewBinding.btnFragment31.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.frameFragment3.id, FirstFragment())
                    .commitAllowingStateLoss()

            }

            viewBinding.btnFragment32.setOnClickListener{
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.frameFragment3.id,SecondFragment())
                    .commitAllowingStateLoss()
            }

        }
    }
}

