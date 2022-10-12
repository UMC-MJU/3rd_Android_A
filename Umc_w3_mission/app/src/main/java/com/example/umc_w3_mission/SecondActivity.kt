package com.example.umc_w3_mission

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_w3_mission.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val extras = intent.extras
        var data = extras!!["number"]
        var age_int = Integer.parseInt(data.toString())
        viewBinding.tvInputAge.text = (age_int + 1).toString()

        viewBinding.btnNext.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

       viewBinding.btnBack.setOnClickListener {
           val intent = Intent(this, MainActivity::class.java)
           intent.putExtra("String", "다시 왔네! 안뇽")
           setResult(RESULT_OK, intent)
           finish()
       }
    }





}