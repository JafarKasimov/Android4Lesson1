package com.example.android4lesson1.models

import com.google.gson.annotations.SerializedName

data class ResponseModel<T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("links")
    val links: Links

)