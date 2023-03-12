package com.dave_devs.signupandloginwithfirebaseauthentication.domain

sealed class LoginAuthenticationType {
    object Valid: LoginAuthenticationType()
    object EmptyField: LoginAuthenticationType()
    object InvalidEmail: LoginAuthenticationType()
}
