package com.vicky.halodoctest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitBuilder {

    const val BASE_URL = "https://picsum.photos/v2/"

    private fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

            val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}