package com.robelseyoum.airvettakehomecoding.ui.randomuseroverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robelseyoum.airvettakehomecoding.databinding.ActivityRandomuserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRandomuserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomuserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}