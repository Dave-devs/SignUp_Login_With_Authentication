package com.dave_devs.signupandloginwithfirebaseauthentication.domain.use_cases

import com.dave_devs.signupandloginwithfirebaseauthentication.domain.LoginAuthenticationType

class LoginAuthenticationUseCase {

    operator fun invoke(name: String, email: String, passWord: String): LoginAuthenticationType {
        if(name.isEmpty() || email.isEmpty() || passWord.isEmpty()) {
            return LoginAuthenticationType.EmptyField
        }
        if("@gmail.com" !in email) {
            return LoginAuthenticationType.InvalidEmail
        }
        return LoginAuthenticationType.Valid
    }
}