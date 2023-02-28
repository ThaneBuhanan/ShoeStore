package com.udacity.shoestore.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoelist.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater, R.layout.fragment_shoe_details, container, false
        )
        binding.cancelButton.setOnClickListener { goBack() }
        binding.saveButton.setOnClickListener {
            saveShoe(
                binding.nameEdit.text.toString(),
                binding.sizeEdit.text.toString().toDouble(),
                binding.companyEdit.text.toString(),
                binding.detailsEdit.text.toString(),
            )
        }

        return binding.root
    }

    private fun goBack() {
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
    }

    private fun saveShoe(
        name: String,
        size: Double,
        company: String,
        details: String
    ) {
        viewModel.addShoe(Shoe(name, size, company, details))

        goBack()
    }

}