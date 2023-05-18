package com.example.fifthstreet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fifthstreet.databinding.ActivityIntroBinding

class introActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
    }
}