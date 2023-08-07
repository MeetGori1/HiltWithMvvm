package com.example.hiltwithmvvm.retrofit

import com.example.hiltwithmvvm.models.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getData( ): Response<List<ProductModel>>
}