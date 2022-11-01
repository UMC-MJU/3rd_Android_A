package com.example.challenge_4

import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.challenge_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var temp: String
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.button.setOnClickListener{
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", viewBinding.editText.text.toString())
            startActivity(intent)
        }

        Log.d("Lifecycle", "onCreate")
    }

    override fun onStop() {
        super.onStop()
        temp = viewBinding.editText.text.toString()
        viewBinding.editText.setText("")

        Log.d("Lifecycle", "onStop")
    }

    override fun onStart() {
        super.onStart()

        var mediaPlayer = MediaPlayer.create(this.applicationContext, R.raw.stars)
        mediaPlayer.start()
        Log.d("Lifecycle", "onStart")
    }

    override fun onRestart() {
        super.onRestart()

        AlertDialog.Builder(this)
            .setTitle("Title")
            .setMessage("이어서 작성하시겠습니까?")
            .setPositiveButton("ok", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    Log.d("MyTag", "positive")
                    viewBinding.editText.setText(temp)
                }
            })
            .setNegativeButton("no", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    Log.d("MyTag", "negative")
                    temp = ""
                    viewBinding.editText.setText("")
                }
            })
            .create()
            .show()

        Log.d("Lifecycle", "onRestart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("Lifecycle", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Lifecycle", "onDestroy")
    }



}