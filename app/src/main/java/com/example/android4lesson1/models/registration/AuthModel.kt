package com.example.android4lesson1.models.registration

import com.google.gson.annotations.SerializedName

data class AuthModel(
    @SerializedName("password")
    val password: String,
    @SerializedName("grant_type")
    val grantType: String = "password",
    @SerializedName("username")
    val email: String
)