package com.example.challenge_5

import android.content.Intent
import android.os.Bundle
import android.service.autofill.Dataset
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_5.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val dataList: ArrayList<DataSetting> = arrayListOf()
        val settingAadapter = DataRVAdapterForSetting(dataList)

        dataList.apply {
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))

            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))

            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))

            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
            dataList.add(DataSetting("알림 설정", false))
        }

        viewBinding.rvData.adapter = settingAadapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        viewBinding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}