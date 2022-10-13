package com.vicky.halodoctest.persentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vicky.halodoctest.model.ImageResultModel
import com.vicky.halodoctest.network.ApiService
import com.vicky.halodoctest.network.NetworkHelper
import com.vicky.halodoctest.network.RetrofitBuilder
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val images = MutableLiveData<List<ImageResultModel>>()

    init {
        getImageData()
    }

    private fun getImageData() {
        viewModelScope.launch {
            try {
                val resultData = NetworkHelper(RetrofitBuilder.apiService).getImageData()
                images.postValue(resultData)
            } catch (e: Exception) {
                Log.e("MainViewModel", e.toString())
            }

        }

    }

    fun getImages(): LiveData<List<ImageResultModel>> = images
}