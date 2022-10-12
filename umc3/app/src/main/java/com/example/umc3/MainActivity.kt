package com.example.umc3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 이 activity 내에서만 사용
    // lateinit 나중에 초기화 할거임, onCreate 하자마자 초기화 할거임
    // viewBinding이라는 이름으로 짓고 타입은 ActivityMainBinding, aetivity_second면 ActivitySecond~~
    private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바로 viewBinding 변수에 값을 할당
        // inflate는 layout xml파일을 해석하겠다는 거고, 이를 위해 layoutInflater가 필요함
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        // 이거를 안바꾸면 viewBinding 쓰는 의미가 없음
        // viewBinding.root하면 이 root라는 의미가 Activity_main.xml의 짱부모.
        setContentView(viewBinding.root)


        // onCLick event Listener
        viewBinding.btnNext.setOnClickListener {
            // Activity 이동하기 위해서 Intent 객체 만들어줘야함
            // Intent 빈 객체로 만들 수 있지만 명시적으로 어디에 이동할지 알아야하니까 일반적으로 this적고 이동할 Activity 적음
            // this, 즉 Main에서 Second로 이동하겠다는 Intent를 만들어줌
            val intent = Intent(this, SecondActivity::class.java)


            // intent 에 정보 담기
            // putExtra, 많은 값을 담을 수 있는데 name이랑 value가 꼭 있어야함
            intent.putExtra("text", viewBinding.mainText.text)
//            intent.putExtra("text", "이러니까좀재미있네")
            // intent에 이러니까좀재미있네 라는 값을 보내는거임
            // 오류나면 clean project - rebuild 하면 binding이 없다고 하는 오류 해결
            // 보내는 게 끝이 아니라 보내는 곳에서 데이터를 받아줘야함


            // 단순히 넘어가기
            startActivity(intent)

            // 기본 화면이 있어야함 기본 화면 표시 만들기
            // 기본 화면을 표시하는 것은 fragment를 설정하는건데 supportFragmentManage 사용

//            supportFragmentManager
//                .beginTransaction() // 시작하겠다
//                .replace(viewBinding.frameFragment.id,FirstFragment())
//                .commitAllowingStateLoss() // commit을 해주는데 state가 날라가는 것을 허용
//                // activity가 시작할 때 오류 방지.
//
//            viewBinding.btnFragment1.setOnClickListener {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(viewBinding.frameFragment.id, FirstFragment())
//                    .commitAllowingStateLoss()
//
//            }
//
//            viewBinding.btnFragment2.setOnClickListener{
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(viewBinding.frameFragment.id,SecondFragment())
//                    .commitAllowingStateLoss()
//            }

        }
    }
}

