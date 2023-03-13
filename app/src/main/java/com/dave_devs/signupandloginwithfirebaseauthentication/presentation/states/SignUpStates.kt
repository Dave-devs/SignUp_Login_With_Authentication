package com.dave_devs.signupandloginwithfirebaseauthentication.presentation.states

data class SignUpStates(
    val nameInput: String = "",
    val emailInput: String = "",
    val passwordInput: String = "",
    val repeatedPasswordInput: String = "",
    val isInputValid: Boolean = false,
    val isPasswordShown: Boolean = false,
    val isRepeatedPasswordShown: Boolean = false,
    val errorMessageInput: String? = null,
    val isLoading: Boolean = false,
    val isSuccessfullySignedUp: Boolean = false,
    val errorMessageSignUpProcess: String? = null
)
