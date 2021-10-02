package com.robelseyoum.airvettakehomecoding.ui.randomuserdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.robelseyoum.airvettakehomecoding.databinding.FragmentRandomUserDetailBinding

class DetailRandomUserFragment : Fragment() {

    private lateinit var binding: FragmentRandomUserDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomUserDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val detailUser =  DetailRandomUserFragmentArgs.fromBundle(requireArguments()).selectedRandomUser
        binding.userDetails = detailUser
        return binding.root
    }
}