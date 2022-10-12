package com.example.challenge_3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.challenge_3.databinding.ActivityThirdBinding


class ThirdActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val first = FirstFragment()
        val second = SecondFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameFragment.id, first)
            .commitAllowingStateLoss()

        viewBinding.btnFst.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, first)
                .commitAllowingStateLoss()
        }

        viewBinding.btnSnd.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, second)
                .commitAllowingStateLoss()
        }

        supportFragmentManager
            .setFragmentResultListener("requestKey", this) {
                requestKey, bundle ->
                val result = bundle.getString("bundleKey")
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
    }
}
