package com.robelseyoum.airvettakehomecoding.ui.randomuseroverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.robelseyoum.airvettakehomecoding.databinding.FragmentRandomUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomUserFragment : Fragment() {

    private val TAG: String = "AppDebug"
    private lateinit var binding: FragmentRandomUserBinding
    private val viewModel: RandomUserViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomUserBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.randomUserViewModel = viewModel
        return binding.root
    }

    private fun initSubscriptions() {

    }
}