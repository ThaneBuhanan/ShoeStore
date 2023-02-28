package com.udacity.shoestore.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater, R.layout.fragment_shoe_details, container, false
        )
        binding.cancelButton.setOnClickListener { cancelTask() }
        binding.saveButton.setOnClickListener {
            saveShoe(
                binding.nameEdit.text.toString(),
                binding.sizeEdit.text.toString().toInt(),
                binding.companyEdit.text.toString(),
                binding.detailsEdit.text.toString(),
            )
        }

        return binding.root
    }

    private fun saveShoe(
        name: String,
        size: Int,
        company: String,
        details: String
    ) {
        TODO("Not yet implemented")
    }

    private fun cancelTask() {
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
    }

}