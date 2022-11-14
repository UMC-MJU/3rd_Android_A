package com.example.challenge_7

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.challenge_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var handler = Handler(Looper.getMainLooper())

        Thread() {
            for (i in 1..5) {
                Thread.sleep(1000)
                handler.post {
                    binding.timeArea.text = i.toString()
                }
            }
        }.start()

        Thread() {
            Thread.sleep(5000)
            handler.post {
                Log.d("MYTAG", "toast")
            }
        }.start()
    }
}