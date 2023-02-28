package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        binding.addShoeButton.setOnClickListener { launchShoeDetails() }

        viewModel.shoeList.observe(viewLifecycleOwner) { listOfShoes ->
            binding.shoesList.removeAllViews()
            listOfShoes.forEach {
                val shoeBinding = DataBindingUtil.inflate<ShoeItemBinding>(
                    inflater, R.layout.shoe_item, container, false
                )
                shoeBinding.shoe = it

                binding.shoesList.addView(shoeBinding.root)
            }
        }

        return binding.root
    }

    private fun launchShoeDetails() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
    }
}