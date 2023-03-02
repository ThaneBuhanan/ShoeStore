package com.udacity.shoestore.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoelist.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    private val viewModel: ShoeDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater, R.layout.fragment_shoe_details, container, false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener { goBack() }
        binding.saveButton.setOnClickListener {
            saveShoe(
                viewModel.name.value.toString(),
                viewModel.size.value.toString().toDouble(),
                viewModel.company.value.toString(),
                viewModel.details.value.toString(),
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
        shoeListViewModel.addShoe(Shoe(name, size, company, details))

        goBack()
    }

}