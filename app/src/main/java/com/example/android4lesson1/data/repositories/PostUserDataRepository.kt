package com.example.android4lesson1.data.repositories

import com.example.android4lesson1.base.BaseRepository
import com.example.android4lesson1.data.remote.apiserveces.SignInApiService
import com.example.android4lesson1.models.registration.AuthModel
import javax.inject.Inject

class PostUserDataRepository @Inject constructor(
    private val apiService: SignInApiService
): BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest {
        apiService.postAuthDataUser(authModel)
    }
}