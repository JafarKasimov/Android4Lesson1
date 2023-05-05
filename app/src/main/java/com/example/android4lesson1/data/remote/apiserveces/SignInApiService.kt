package com.example.android4lesson1.data.remote.apiserveces

import com.example.android4lesson1.models.registration.AuthModel
import com.example.android4lesson1.models.registration.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {
    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModel
    ) : TokenModel
}