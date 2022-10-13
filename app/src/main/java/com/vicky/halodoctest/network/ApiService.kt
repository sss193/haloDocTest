package com.vicky.halodoctest.network

import com.vicky.halodoctest.model.ImageResultModel
import retrofit2.http.GET

interface ApiService {
    @GET("list?page=2&limit=100")
    suspend fun getImageData(): List<ImageResultModel>
}