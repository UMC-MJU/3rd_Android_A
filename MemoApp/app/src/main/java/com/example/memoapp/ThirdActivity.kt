package com.example.memoapp

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.memoapp.databinding.ActivityThirdBinding
import kotlin.properties.Delegates

class ThirdActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityThirdBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    private var soundPool: SoundPool? = null
    private var soundId by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // intent 구분
        if(intent.hasExtra("update_item"))
            viewBinding.textView.text = intent.getStringExtra("update_item")

        // SecondActivity Result를 받기 위해 Callback 등록
        getResultText = registerForActivityResult (
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == 2) {
                val intent = result.data
//                Log.d("수정할 아이템 인텐트", "${intent!!.hasExtra("save_item")}")
                viewBinding.textView.text = intent!!.getStringExtra("save_item")
            }
            else if (result.resultCode == RESULT_CANCELED) {
                // RESULT_CANCELED result를 받으면, SecondActivity에서 저장 안 했다는 뜻
                // 바로 MainActivity로 넘어갈 수 있도록 종료하기
                // onStop()일 때 저장된 메모 바로바로 MainActivity로 intent 보내므로 누락X
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        soundPoolInit()
        soundId = soundPool?.load(this, R.raw.success_sound, 1)!!
    }

    override fun onResume() {
        super.onResume()
        viewBinding.textView.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("update_item", viewBinding.textView.text)
            getResultText.launch(intent)
        }
        viewBinding.btnBack.setOnClickListener {
            sendMemoToMain()
            finish()
            soundPool!!.play(soundId, 1f, 1f, 0, 0, 1f)
        }
    }

    override fun onStop() {
        super.onStop()
        soundPoolRelease()
        // 지금까지 작성(저장)된 메모 MainActivity result로 설정
        sendMemoToMain()
    }

    private fun sendMemoToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("completed_item", viewBinding.textView.text)
        setResult(3, intent)
    }

    // 효과음 재생을 위한 SoundPool Method
    private fun soundPoolInit() {
        if (soundPool == null) {
            soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
                SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(8).build()
            } else {
                SoundPool(8, AudioManager.STREAM_MUSIC, 0)
            }
        }
    }
    private fun soundPoolRelease() {
        soundPool!!.release()
        soundPool = null
    }
}