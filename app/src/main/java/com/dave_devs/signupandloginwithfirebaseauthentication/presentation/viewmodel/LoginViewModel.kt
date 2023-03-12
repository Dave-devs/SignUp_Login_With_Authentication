package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases.LoginAuthenticationUseCase
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.LoginAuthenticationType
import com.dave_devs.signupandloginwithfirebaseauthentication.presentation.states.LoginStates
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginAuthenticationUseCase: LoginAuthenticationUseCase
): ViewModel() {

    //Private set to be able to change in viewModel
    var loginState by mutableStateOf(LoginStates())
        private set

    fun onNameInputChange(newValue: String) {
        loginState = loginState.copy(
            nameInput = newValue
        )
        checkInputValidation()
    }
    fun onEmailInputChange(newValue: String) {
        loginState = loginState.copy(
            emailInput = newValue
        )
        checkInputValidation()
    }
    fun onPasswordInputChange(newValue: String) {
        loginState = loginState.copy(
            passwordInput = newValue
        )
        checkInputValidation()
    }
    fun onToggleVisibilityTransformation() {
        loginState = loginState.copy(
            isPasswordShown = !loginState.isPasswordShown
        )
    }

    private fun checkInputValidation() {
        val validationResult = loginAuthenticationUseCase(
            loginState.nameInput,
            loginState.emailInput,
            loginState.passwordInput
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(type: LoginAuthenticationType) {
        loginState = when(type) {
            LoginAuthenticationType.EmptyField -> {
                loginState.copy(errorMessageInput = "An empty field left", isInputValid = false)
            }
            LoginAuthenticationType.InvalidEmail -> {
                loginState.copy(errorMessageInput = "Invalid Email", isInputValid = false)
            }
            LoginAuthenticationType.Valid -> {
                loginState.copy(errorMessageInput = null, isInputValid = true)
            }
        }
    }
}