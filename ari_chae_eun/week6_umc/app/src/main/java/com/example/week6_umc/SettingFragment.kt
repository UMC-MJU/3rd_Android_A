package com.example.week6_umc

import android.media.SoundPool
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6_umc.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    private lateinit var mSoundPool : SoundPool

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(layoutInflater)
        var handler = Handler(Looper.getMainLooper())
        Thread(){
            for(i: Int in 1..10){
                Thread.sleep(1000)
                handler.post {
                    binding.timerText.text = i.toString()
                }
                if(i == 10){
                    val soundPool = SoundPool.Builder().build()
                    val soundId = soundPool.load(activity, R.raw.sound1, 1)
                    soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f)
                }
            }
        }.start()

        return binding.root
    }

}