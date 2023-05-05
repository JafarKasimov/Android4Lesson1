package com.example.android4lesson1.models.registration

import com.google.gson.annotations.SerializedName

data class TokenModel(
    @SerializedName("refresh_token")
    val refreshToken: String = "",
    @SerializedName("grant_type")
    val grantType: String = ""
)