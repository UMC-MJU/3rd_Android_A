package com.example.umcandriod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.AutoText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.example.umcandriod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.mainBtn.setOnClickListener{
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("text", viewBinding.mainText.text.toString())
            getResultText.launch(intent)
        }

        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK){
                val intent = result.data
                val data = intent!!.getStringExtra("test")
                Toast.makeText(this, data, Toast.LENGTH_LONG).show();
            }
        }

    }

}