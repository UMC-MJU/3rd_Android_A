package com.example.week4_umc

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.week4_umc.databinding.ActivityMainBinding
import com.example.week4_umc.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySecondBinding
    companion object{
        var textString:String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        viewBinding.secondBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", viewBinding.editText.text.toString())
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        textString = viewBinding.editText.text.toString()
        viewBinding.editText.text = null
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this).
                setMessage("이어서 작성 하시겠습니까?").
                setPositiveButton("Yes", object : DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        viewBinding.editText.setText(textString)
                    }
                }).
                setNegativeButton("NO", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                    }
                }).create().show()
    }

}