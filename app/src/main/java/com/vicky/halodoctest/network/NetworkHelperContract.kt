package com.vicky.halodoctest.network

import com.vicky.halodoctest.model.ImageResultModel
import retrofit2.http.GET

interface NetworkHelperContract {

    suspend fun getImageData(): List<ImageResultModel>
}