package com.robelseyoum.airvettakehomecoding.ui.randomuseroverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robelseyoum.airvettakehomecoding.databinding.ActivityRandomUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRandomUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}