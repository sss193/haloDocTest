package com.vicky.halodoctest.model

import com.google.gson.annotations.SerializedName

data class ImageResultModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("download_url")
    val download_url: String

)

