package com.dave_devs.signupandloginwithfirebaseauthentication.domain.util

sealed class SignUpAuthenticationType {
    object Valid: SignUpAuthenticationType()
    object EmptyField: SignUpAuthenticationType()
    object InvalidEmail: SignUpAuthenticationType()
    object PasswordDoNotMatch: SignUpAuthenticationType()
    object PasswordUpperCaseMissing: SignUpAuthenticationType()
    object PasswordSpecialCharMissing: SignUpAuthenticationType()
    object PasswordTooSort: SignUpAuthenticationType()
}
