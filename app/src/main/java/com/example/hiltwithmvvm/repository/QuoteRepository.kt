package com.example.hiltwithmvvm.repository

import com.example.hiltwithmvvm.models.ProductModel
import com.example.hiltwithmvvm.retrofit.RetrofitHelper
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor() {
    suspend fun getProduct(): Response<List<ProductModel>> {
        return RetrofitHelper.getInstance().getData()
    }
}