package com.dave_devs.signupandloginwithfirebaseauthentication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases.SignUpAuthenticationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpAuthenticationUseCase: SignUpAuthenticationUseCase
): ViewModel() {

    var signUpState by mutableStateOf(SignUpStates())
        private set

    fun onNameInputChange(newValue: String){
        signUpState = signUpState.copy(
            nameInput = newValue
        )
    }
    fun onEmailInputChange(newValue: String){
        signUpState = signUpState.copy(
            emailInput = newValue
        )
    }
    fun onPasswordInput(newValue: String) {
        signUpState = signUpState.copy(
            passwordInput = newValue
        )
    }
    fun onToggleVisibilityTransformation() {
        signUpState = signUpState.copy(
            isPasswordShown = !signUpState.isPasswordShown
        )
    }
}