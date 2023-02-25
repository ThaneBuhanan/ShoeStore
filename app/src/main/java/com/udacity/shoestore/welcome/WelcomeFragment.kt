package com.udacity.shoestore.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private val viewModel: WelcomeViewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater, R.layout.fragment_welcome, container, false
        )
        binding.seeInstructions.setOnClickListener { launchInstructions() }

        return binding.root
    }

    private fun launchInstructions() {
        findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
    }
}