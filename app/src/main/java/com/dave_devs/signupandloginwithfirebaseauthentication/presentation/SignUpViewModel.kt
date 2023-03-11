package com.dave_devs.signupandloginwithfirebaseauthentication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases.SignUpAuthenticationUseCase
import com.dave_devs.signupandloginwithfirebaseauthentication.domain.util.SignUpAuthenticationType
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
         checkInputValidation()
    }
    fun onEmailInputChange(newValue: String){
        signUpState = signUpState.copy(
            emailInput = newValue
        )
         checkInputValidation()
    }
    fun onPasswordInput(newValue: String) {
        signUpState = signUpState.copy(
            passwordInput = newValue
        )
         checkInputValidation()
    }
    fun onRepeatedPasswordInput(newValue: String) {
        signUpState = signUpState.copy(
            repeatedPasswordInput = newValue
        )
        checkInputValidation()
    }
    fun onToggleVisibilityTransformation() {
        signUpState = signUpState.copy(
            isPasswordShown = !signUpState.isPasswordShown,
            isRepeatedPasswordShown = !signUpState.isRepeatedPasswordShown
        )
    }
    private fun checkInputValidation() {
        val validationResult = signUpAuthenticationUseCase(
            signUpState.nameInput,
            signUpState.emailInput,
            signUpState.passwordInput,
            signUpState.repeatedPasswordInput
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(type: SignUpAuthenticationType) {
        signUpState = when(type) {
            is SignUpAuthenticationType.Valid -> {
                signUpState.copy(errorMessageInput = null, isInputValid = true )
            }
            is SignUpAuthenticationType.EmptyField -> {
                signUpState.copy(errorMessageInput = "An empty field left", isInputValid = false)
            }
            is SignUpAuthenticationType.InvalidEmail -> {
                signUpState.copy(errorMessageInput = "An invalid email", isInputValid = false)
            }
            is SignUpAuthenticationType.PasswordTooSort -> {
                signUpState.copy(errorMessageInput = "Password is less than 10 characters", isInputValid = false)
            }
            is SignUpAuthenticationType.PasswordSpecialCharMissing -> {
                signUpState.copy(errorMessageInput = "Password must contain at least one special character", isInputValid = false)
            }
            is SignUpAuthenticationType.PasswordUpperCaseMissing -> {
                signUpState.copy(errorMessageInput = "Password must contain at least one capital letter", isInputValid = false)
            }
            is SignUpAuthenticationType.PasswordDoNotMatch -> {
                signUpState.copy(errorMessageInput = "Password do not match", isInputValid = false)
            }
        }
    }
}