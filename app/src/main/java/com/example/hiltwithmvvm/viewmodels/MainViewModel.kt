package com.example.hiltwithmvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltwithmvvm.models.ProductModel
import com.example.hiltwithmvvm.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject  constructor( private val repository: ProductRepository) : ViewModel() {
    var productsLiveData: MutableLiveData<List<ProductModel>> =MutableLiveData()

    init {
        viewModelScope.launch {
            getProduct()
        }
    }

    suspend fun getProduct(){
        var data= repository.getProduct()
        productsLiveData.postValue(data.body())
    }
}