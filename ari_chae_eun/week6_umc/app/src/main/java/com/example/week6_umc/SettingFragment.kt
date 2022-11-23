package com.example.week6_umc

import android.media.SoundPool
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6_umc.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(layoutInflater)
        var handler = Handler(Looper.getMainLooper())

        val soundPool = SoundPool.Builder().build()
        val soundId = soundPool.load(activity, R.raw.sound1, 1)

        Thread(){
            for(i: Int in 1..10){
                Thread.sleep(1000)
                handler.post {
                    binding.timerText.text = i.toString()
                }
                if(i == 10){
                    Log.e("Test", "Played sound");
                    soundPool.play(soundId, 0.7f, 0.7f,0,0,1f)
                }
            }
        }.start()

        return binding.root
    }

}