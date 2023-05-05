package com.example.android4lesson1.models

import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("data")
    val dataItem: DataItem
)
