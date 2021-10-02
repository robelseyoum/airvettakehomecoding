package com.robelseyoum.airvettakehomecoding.ui.randomuseroverview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.robelseyoum.airvettakehomecoding.R
import com.robelseyoum.airvettakehomecoding.databinding.FragmentRandomUserBinding
import com.robelseyoum.airvettakehomecoding.utils.setDivider
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
        binding.randomList.setDivider(R.drawable.recycler_view_divider)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSubscriptions()
    }

    private fun initSubscriptions() {
        binding.randomList.adapter = RandomUserAdapter(RandomUserAdapter.OnClickListener {
                viewModel.displayRandomUserDetails(it)
        })


        viewModel.navigateToSelectedRandomUser.observe(viewLifecycleOwner, Observer {
            if(it != null){
                this.findNavController().navigate(RandomUserFragmentDirections.actionShowDetail(it))
                viewModel.displayStatusDetailsComplete()
            }
        })

        binding.btnRetry.setOnClickListener {
            viewModel.fetchRandomUser()
            binding.errorMessageContainer.visibility = View.GONE
        }

        viewModel.randomUserApiData.observe(viewLifecycleOwner, Observer {
            Log.v(TAG, "${viewModel.randomUserApiData.value}")
        })
    }
}