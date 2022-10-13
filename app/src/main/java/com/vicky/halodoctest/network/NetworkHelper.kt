package com.vicky.halodoctest.network

import com.vicky.halodoctest.model.ImageResultModel

class NetworkHelper(private val apiService: ApiService) : NetworkHelperContract {
    override suspend fun getImageData(): List<ImageResultModel> = apiService.getImageData()

}