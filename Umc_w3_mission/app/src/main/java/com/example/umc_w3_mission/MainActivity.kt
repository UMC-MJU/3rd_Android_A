package com.example.umc_w3_mission

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.umc_w3_mission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnNext.setOnClickListener {
            var age = viewBinding.editText.text
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("number", age)
            startActivity(intent)
            getResultText.launch(intent)
        }



        //
        getResultText = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val intent = result.data
                val stringVal = intent!!.getStringExtra("String")

                Toast.makeText(this, stringVal, Toast.LENGTH_SHORT).show()
            }
        }

    }
}