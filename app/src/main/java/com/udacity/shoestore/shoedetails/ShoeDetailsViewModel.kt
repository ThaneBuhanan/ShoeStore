package com.udacity.shoestore.shoedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailsViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val details = MutableLiveData<String>()

}