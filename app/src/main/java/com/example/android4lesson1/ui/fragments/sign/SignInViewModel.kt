package com.example.android4lesson1.ui.fragments.sign

import com.example.android4lesson1.base.BaseViewModel
import com.example.android4lesson1.data.repositories.PostUserDataRepository
import com.example.android4lesson1.models.registration.AuthModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: PostUserDataRepository
) : BaseViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}