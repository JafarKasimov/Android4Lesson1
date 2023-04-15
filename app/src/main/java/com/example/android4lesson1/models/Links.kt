package com.example.android4lesson1.models

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("next")
    val next: String = "",

    @SerializedName("last")
    val last: String = "",

    @SerializedName("first")
    val first: String = ""
)