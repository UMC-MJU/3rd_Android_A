package com.example.week9_umc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week9_umc.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        
        // builder 패턴
        // 웹 브라우저 창 열기
        val retrofit = Retrofit.Builder()
            .baseUrl("https://prodmp.eric-rc.shop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 어떤 주소를 입력했다.
        val apiService = retrofit.create(APIService::class.java)

        // 입력한 주소 중에 하나로 연결 시도
        apiService.getCheckEmail("abc@abc.com").enqueue(object: Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if(response.isSuccessful){
                    val responseData = response.body()
                    if(responseData != null){
                        // api 에서 보내주는 내부 code
                        // 서버 개발자가 생성한 코드
                        Log.e("Retrofit", "Response\n Code: ${responseData.code} Message: ${responseData.message}")
                    }else {
                        // http 에서 제곻하는 오류 코드
                        // 전 세계적으로 규격이 있는 코드
                        Log.w("Retrofit", "Response Successful ${response.code()}")
                    }
                }

            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("Retrofit", "Error!")
            }

        })
    }
}