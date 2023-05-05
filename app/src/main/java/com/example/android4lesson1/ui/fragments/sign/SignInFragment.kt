package com.example.android4lesson1.ui.fragments.sign

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1.R
import com.example.android4lesson1.base.BaseFragment
import com.example.android4lesson1.data.local.preferences.PreferencesHelper
import com.example.android4lesson1.data.local.preferences.UserPreferencesData
import com.example.android4lesson1.databinding.FragmentSignInBinding
import com.example.android4lesson1.models.registration.AuthModel
import com.example.android4lesson1.ui.showText
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun setupListeners() {
        subscribeToSignIn()
    }

    private fun subscribeToSignIn() = with(binding) {

        signInBtn.setOnClickListener {

            val email = inputLayoutNickName.text.toString()
            val password = inputLayoutPassword.text.toString()
            val authModel = AuthModel(password,  "password", email)

            viewModel.postUserData(authModel).subscribe(
                onError = {
                    Log.e("TAG", "setupSubscribes: $it")
                },
                onSuccess = {
                    if (it != null) {
                        userPreferencesData.apply {
                            isAuthorized = true
                            accessToken = it.grantType
                            refreshToken = it.refreshToken
                        }
                        requireActivity().findNavController(R.id.nav_host_fragment)
                            .navigate(R.id.action_singFlowFragment_to_homeFlowFragment)
                    }
                }
            )
        }
    }
}