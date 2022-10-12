package com.example.umc3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc3.databinding.ActivityMainBinding
import com.example.umc3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)


        setContentView(viewBinding.root)
        // 무조건 manifest에 등록을 해야되는데 이게 애초에 Activity로 만들면 manifest에 자동으로 등록됨
        // Activity로 생성하지 않았을 시 manifest에 어떠한 Activity를 사용할거라고 적어줘야함

        // main에서 putExtra로 정보를 넣었기 때문에 extras에 그 정보가 담겨있음
        val extras = intent.extras

        // !! 느낌표는 name 의 value가 무조건 null이 아니다. 내가 개발자니까 장담한다 이런 의미임
        val data = extras!!["text"] as String // 강제 형변환

        viewBinding.secondTx.text = data

        intent.putExtra("text4", viewBinding.thirdTx.text)

        viewBinding.secondBtn.setOnClickListener {
            // Activity 이동하기 위해서 Intent 객체 만들어줘야함
            // Intent 빈 객체로 만들 수 있지만 명시적으로 어디에 이동할지 알아야하니까 일반적으로 this적고 이동할 Activity 적음
            // this, 즉 Main에서 Second로 이동하겠다는 Intent를 만들어줌
            val intent = Intent(this, ThirdActivity::class.java)


            // intent 에 정보 담기
            // putExtra, 많은 값을 담을 수 있는데 name이랑 value가 꼭 있어야함
            intent.putExtra("text3", "두번째 액티비티에서 넘어옴")
//            intent.putExtra("text", "이러니까좀재미있네")
            // intent에 이러니까좀재미있네 라는 값을 보내는거임
            // 오류나면 clean project - rebuild 하면 binding이 없다고 하는 오류 해결
            // 보내는 게 끝이 아니라 보내는 곳에서 데이터를 받아줘야함


            // 단순히 넘어가기
            startActivity(intent)


        }
    }
}